import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        System.out.println("Welcome to the Organisation Management System!\n"+"Please select an option:\n"+"1. Login\n"+"2. Register\n"+"3. Exit");
        Scanner input = new Scanner(System.in);
        int option = input.nextInt();
        switch(option){
            case 1:
                System.out.println("Please enter your email:");
                String email = input.next();
                System.out.println("Please enter your password:");
                String password = input.next();
                break;
            case 2:
                System.out.println("Please enter your name:");
                String name = input.next();
                System.out.println("Please enter your email:");
                email = input.next();
                System.out.println("Please enter your password:");
                password = input.next();
                System.out.println("Please enter your role:");
                String role = input.next();
                break;
            case 3:
                System.out.println("Thank you for using the Organisation Management System!");
                break;
            default:
                System.out.println("Invalid option !");
                break;
        }
    }
}