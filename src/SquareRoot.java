import java.lang.Math;

public class SquareRoot {
    public static void main(String []args){
        for(double i = 1; i <= 100; i++) {
            double a = Math.sqrt(i);
            System.out.println(a);
            System.out.println("Rounding Error: " + Math.round(a * 100) / 100.0);
        }
    }
}
