public interface Deque<AnyType> {
    public void addFirst(AnyType item);
    public void addLast(AnyType item);
    public AnyType removeFirst();
    public AnyType removeLast();
    public AnyType getFirst();
    public AnyType getLast();
    public AnyType get(int index);
    public boolean isEmpty();
    public int size();
    public void clear();
}
