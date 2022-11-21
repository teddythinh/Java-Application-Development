import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Contacts {
    private String firstname;
    private String lastname;
    private String phone;

    public Contacts() {
        firstname = "";
        lastname = "";
        phone = "";
    }

    public Contacts(String firstname, String lastname, String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String printContact() {
        return firstname + " " + lastname + " " + phone;
    }
}

class ContactsIO {

    public ArrayList<Contacts> ReadFile(String filename) {
        ArrayList<Contacts> contacts = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File(filename));
            while (input.hasNext()) {
                String firstname = input.next();
                String lastname = input.next();
                String phone = input.next();
                contacts.add(new Contacts(firstname, lastname, phone));
            }
            input.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        return contacts;
    }

    public void WriteFile(String filename, ArrayList<Contacts> contacts) {
        try {
            PrintWriter output = new PrintWriter(new File(filename));
            for (Contacts contact : contacts) {
                output.println(contact.printContact());
            }
            output.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }
}

class business {
    public static void addContact(ArrayList<Contacts> contacts) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the first name: ");
            String firstname = input.next();
            System.out.println("Enter the last name: ");
            String lastname = input.next();
            System.out.println("Enter the phone number: ");
            String phone = input.next();
            contacts.add(new Contacts(firstname, lastname, phone));
            input.close();
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void deleteContact(ArrayList<Contacts> contacts, int index) {
        try {
            contacts.remove(index);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    public static void editContact(ArrayList<Contacts> contacts, int index) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the first name: ");
            String firstname = input.next();
            System.out.println("Enter the last name: ");
            String lastname = input.next();
            System.out.println("Enter the phone number: ");
            String phone = input.next();
            contacts.get(index).setFirstname(firstname);
            contacts.get(index).setLastname(lastname);
            contacts.get(index).setPhone(phone);
            input.close();
        } catch (Exception e) {
            System.out.println("Contact not found");
        }
    }
}

public class Exercise3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ContactsIO contactsIO = new ContactsIO();
        ArrayList<Contacts> contacts = contactsIO.ReadFile("src/Week5/contacts.txt");
        while (true) {
            System.out.println("1. Add a contact");
            System.out.println("2. Delete a contact");
            System.out.println("3. Edit a contact");
            System.out.println("4. Print contacts");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            System.out.print("\n");
            switch (choice) {
                case 1 -> {
                    business.addContact(contacts);
                }
                case 2 -> {
                    System.out.println("Enter the index of the contact to delete: ");
                    int index = input.nextInt();
                    business.deleteContact(contacts, index);
                }
                case 3 -> {
                    System.out.println("Enter the index of the contact to edit: ");
                    int index1 = input.nextInt();
                    business.editContact(contacts, index1);
                }
                case 4 -> {
                    for (Contacts contact : contacts) {
                        System.out.println(contact.printContact());
                    }
                    System.out.print("\n");
                }
                case 5 -> {
                    contactsIO.WriteFile("src/Week5/contactoutput.txt", contacts);
                    input.close();
                    System.exit(choice);
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
