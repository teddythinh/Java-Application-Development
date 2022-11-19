import java.util.*;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Integer> hashset1 = new HashSet<>();
        hashset1.add(10);
        hashset1.add(20);
        hashset1.add(30);
        hashset1.add(15);
        hashset1.add(20);

        Iterator it = hashset1.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
