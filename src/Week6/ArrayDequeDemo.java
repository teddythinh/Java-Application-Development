import java.util.*;

public class ArrayDequeDemo {
    public static void main(String[] args) {
//        ArrayDeque<Integer> stack = new ArrayDeque<>();
//        stack.addFirst(10);
//        stack.addFirst(20);
//        stack.addFirst(30);
//
//        System.out.println(stack.removeFirst());
//        System.out.println(stack.removeFirst());

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(10);
        queue.addLast(20);
        queue.addLast(30);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
