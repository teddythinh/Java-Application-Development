import java.util.Scanner;

public class Info {
    public static void main(String []args) {
        String firstName, lastName, dob;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your first name: ");
        firstName = scanner.nextLine();
        System.out.print("Enter your last name: ");
        lastName = scanner.nextLine();
        System.out.print("Enter your date of birth (dd/mm/yyyy): ");
        dob = scanner.nextLine();
        System.out.print("Enter your address: ");
        String address = scanner.nextLine();

        System.out.println("Your name is: " + firstName + " " + lastName);
        System.out.println("Your dob is: " + dob);
        System.out.println("Your address is: " + address);
    }
}
