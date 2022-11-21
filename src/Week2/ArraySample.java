import java.util.Scanner;

public class ArraySample {
    public static void main(String[] args) {
//        int sample[];
//        int n;
//        Scanner scanner =  new Scanner(System.in);
//        n = scanner.nextInt();
//
//        sample = new int[n];
//        for(int i = 0; i < sample.length; i++) {
//            sample[i] = i * 10;
//        }
//
//        int temp[] = new int[sample.length + 1];
//
//        for(int i = 0; i < sample.length; i++) {
//            temp[i] = sample[i];
//        }
//
//        temp[10] = 70;
//
//        for(int i = 0; i < sample.length; i++) {
//            System.out.println(sample[i]);
//        }

        int n2 = 4;
        int[][] ire = new int[n2][];

        for (int i = 0; i < n2; i++) {
            ire[i] = new int[i + 1];
        }

        for (int i = 0; i < ire.length; i++) {
            for (int j = 0; j < ire[i].length; j++) {
                System.out.print(ire[i][j] + " ");
            }
            System.out.println();
        }
    }

}
