import java.util.*;

public class ArrayListDemo {
    public static void main(String []args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(20);
        list1.add(0, 30);

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }

        for(Integer x: list1) {
            System.out.println(x);
        }

        Iterator it = list1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}