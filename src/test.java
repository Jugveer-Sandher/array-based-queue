import java.util.*;

public class test {
    public static void main( String [ ] args ) {

        //you can add more test here,
        //comment or remove the following line (it is just to test whether assert is enabled or not
        // if it is not enabled, fix it)
        assert false: "test assert passed!";

        //uncomment the following lines to test your code before submitting your code
        testString();
        testInteger();
        //if there is no error it means your Deque implementation works
    }


    public static void testString() {
        // Do not change this method
        ArrayBasedDeque<String> DequeString = new ArrayBasedDeque<String>();

        DequeString.addFirst("Maryam");
        DequeString.addFirst("Sarah");
        DequeString.addLast("David");
        DequeString.addFirst("Jason");
        DequeString.addLast("John");
        System.out.println(DequeString);
        //output should be: [Jason, Sarah, Maryam, David, John]
        //otherwise there is an error
        String tmp = DequeString.getFirst();
        assert tmp=="Jason": "the frist item should be Jason";
        tmp = DequeString.getLast();
        assert tmp=="John": "the last item should be John";
        tmp = DequeString.get(3);
        assert tmp=="David": "the item at index 3 should be David";

        assert DequeString.getFirst()=="Jason": "the first item should be Jason";

        ArrayList<String> list = new ArrayList<String>();
        int i = 0;
        while (DequeString.isEmpty() == false) {
            if (i == 3) {
                tmp = DequeString.removeFirst();
                assert tmp=="Jason": "the item should be Jason";
                list.add(tmp);
            }
            else
                list.add(DequeString.removeLast());

            i++;
        }

        for (i = 0; i < list.size(); i++) {
            if (i%2 == 0)
                DequeString.addFirst(list.get(i));
            else
                DequeString.addLast(list.get(i));
        }
        System.out.println(DequeString);
        //output should be: [Sarah, Maryam, John, David, Jason]
        //otherwise there is an error

        DequeString.addFirst("Bala");
        DequeString.addLast("Kris");

        assert DequeString.getFirst()=="Bala": "the frist item should be Bala";
        assert DequeString.getLast()=="Kris": "the last item should be Kris";
        assert DequeString.get(3)=="John": "the item at index 1 should be John";
        tmp = DequeString.removeLast();
        assert tmp=="Kris": "the item should be Kris";
        DequeString.addFirst(tmp);
        tmp = DequeString.removeLast();
        assert tmp=="Jason": "the item should be Jason";
        assert DequeString.size()==6: "the item should be 6";
        System.out.println(DequeString);
        //output should be: [Kris, Bala, Sarah, Maryam, John, David]
        //otherwise there is an error
        DequeString.addFirst("Chris");
        DequeString.addLast("Kevin");
        assert DequeString.get(1)=="Kris": "the item at index 1 should be Kris";
        assert DequeString.get(7)=="Kevin": "the item at index 7 should be Kevin";


    }

    public static void testInteger() {
        // Do not change this method
        ArrayBasedDeque<Integer> DequeInt = new ArrayBasedDeque<>();
        DequeInt.addFirst(50);
        DequeInt.addFirst(40);
        DequeInt.addLast(30);
        DequeInt.addFirst(20);
        DequeInt.addLast(10);
        System.out.println(DequeInt.toString());
        //output should be: [20, 40, 50, 30, 10]
        //otherwise there is an error
        int tmp = DequeInt.getFirst();
        assert tmp==20: "the frist item should be 20";
        tmp = DequeInt.getLast();
        assert tmp==10: "the last item should be 10";
        tmp = DequeInt.get(3);
        assert tmp==30: "the item at index 3 should be 30";
        tmp = DequeInt.removeFirst();
        tmp = DequeInt.removeFirst();
        assert tmp==40: "the item should be 40";
        tmp = DequeInt.removeLast();
        tmp = DequeInt.removeFirst();
        tmp = DequeInt.removeLast();
        assert tmp==30: "the item should be 30";
        DequeInt.addFirst(70);
        DequeInt.addLast(60);
        DequeInt.addLast(90);

        assert DequeInt.getFirst()==70: "the frist item should be 70";
        assert DequeInt.getLast()==90: "the last item should be 90";
        assert DequeInt.get(1)==60: "the item at index 1 should be 60";
        tmp = DequeInt.removeLast();
        tmp = DequeInt.removeLast();
        tmp = DequeInt.removeLast();
        assert tmp==70: "the item should be 70";
        System.out.println(DequeInt);
        //output should be: []
        //otherwise there is an error
    }
}
