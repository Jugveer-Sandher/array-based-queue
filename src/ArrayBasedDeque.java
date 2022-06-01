import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayBasedDeque<AnyType> implements Deque<AnyType> {

    private int MAX_SIZE = 5;  // initial array size
    //DO NOT CHANGE this, it is set to 5 to make sure your code
    //will pass all the tests and works with no issue.
    AnyType[] deque;
    int front;
    int rear;
    int count;
    // add all data fields which are required

    /**
     * ArrayBasedDeque() constructs an empty deque.
     */
    public ArrayBasedDeque() {
        deque = (AnyType []) new Object[MAX_SIZE];
        front = -1;
        rear = -1;
        count = 0;
    }

    /**
     * Returns the size of the deque
     *
     * @return the number of elements in this deque
     */
    public int size() {
        return count;
    }

    /**
     * Removes all elements from this deque
     */
    public void clear() {
        count = 0;
        front = -1;
        rear = -1;
    }

    /**
     * Tests if the deque contains no element
     *
     * @return true if the deque contains no element
     */
    public boolean isEmpty() {
        return (count <= 0);
    }

    /**
     * Adds an item to this front of the deque
     *
     * @param x any object
     */
    public void addFirst(AnyType x) {
        if (count == MAX_SIZE) {
            expand();
        }
        if (front < 0) {
            front++;
            rear = front;
        }
        else if (front == 0) {
            front = MAX_SIZE - 1;
        }
        else {
            front -= 1;
        }
        deque[front] = x;
        count++;
    }

    /**
     * Adds an item to this rear of the deque
     *
     * @param x any object
     */
    public void addLast(AnyType x) {
        if (count == MAX_SIZE) {
            expand();
        }
        if (rear < 0) {
            front++;
            rear = front;
        }
        else if (rear == MAX_SIZE - 1) {
            rear = 0;
        }
        else {
            rear += 1;
        }
        deque[rear] = x;
        count++;
    }

    private void expand() {
        AnyType newArray[] = (AnyType []) new Object[2 * MAX_SIZE];
        for (int i = 0; i < count; i++) {
            newArray[i] = deque[(front + i) % MAX_SIZE];
        }
        this.deque = newArray;
        front = 0;
        rear = count - 1;
        MAX_SIZE *=2;
    }

    /**
     * Remove and return the item at the front of the deque.
     *
     * @return the item that was removed from the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public AnyType removeFirst() throws NoSuchElementException {
        if (count == 0) {
            throw new NoSuchElementException("the deque is empty");
        }
        AnyType remove = deque[front];

        if(front >= MAX_SIZE - 1) {
            front = 0;
        }
        else {
            front += 1;
        }
        count--;
        return remove;
    }

    /**
     * Remove and return the item at the rear of the deque.
     *
     * @return the item that was removed from the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public AnyType removeLast() throws NoSuchElementException {
        if (count == 0) {
            throw new NoSuchElementException("the deque is empty");
        }
        AnyType remove = deque[rear];
        if (rear == 0) {
            rear = MAX_SIZE - 1;
        }
        else {
            rear -= 1;
        }
        count--;
        return remove;
    }

    /**
     * Returns the item at position index in deque
     * front of the deque will be considered as index 0,
     * index 1 is the next item, and so on
     *
     * @param index the index to search in
     * @return return the item in index
     * @throws IndexOutOfBoundsException if index is out ot bound
     */
    public AnyType get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Invalid index");
        }
        return deque[(front+count+index) % MAX_SIZE];
    }

    /**
     * Return the item at the rear of the deque.
     *
     * @return the item the rear of the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public AnyType getLast() throws NoSuchElementException {
        if (count <= 0) {
            throw new NoSuchElementException("The deque is empty");
        }
        return deque[rear];
    }

    /**
     * Return the item at the front of the deque.
     *
     * @return the item the front of the deque
     * @throws NoSuchElementException if the deque is empty
     */
    public AnyType getFirst() throws NoSuchElementException {
        if (count <= 0) {
            throw new NoSuchElementException("The deque is empty");
        }
        return deque[front];
    }

    public String toString() {
        StringBuilder result = new StringBuilder("[  ");
        for (int i = 0; i < count; i++) {
            result.append(deque[(front + i) % MAX_SIZE]).append(" ");
        }
        return result + " ]";
    }
}