import Organisation.Admin;
import Organisation.Database;
import Organisation.NormalUser;
import Organisation.User;

import java.util.Scanner;
public class Main {
    static Database newDatabase;
    public static void main(String[] args){
        newDatabase = new Database();
        int option ;
        System.out.println("Welcome to the Organisation Management System!\n");
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Please select an option:\n1. Login\n2. Register\n3. Exit\n");
            option = input.nextInt();
        switch(option){
            case 1:
                System.out.println("Please enter your email:");
                String email = input.next();
                System.out.println("Please enter your password:");
                String password = input.next();
                int loggedInUserId = newDatabase.login(email, password);
                if (loggedInUserId != -1) {
                    // Get the logged-in user using the ID obtained from login
                    User loggedInUser = newDatabase.getUser(loggedInUserId);
                    System.out.println("Login successful!\nWelcome " + loggedInUser.getName() + "!\n");
                    // Pass the loggedInUser to the menu function
                    loggedInUser.menu(newDatabase, loggedInUser);
                }
                else{
                    System.out.println("Invalid email or password!");
                }
                break;
            case 2:
                System.out.println("Please enter your name:");
                String name = input.next();
                System.out.println("Please enter your email:");
                email = input.next();
                System.out.println("Please enter your password:");
                password = input.next();
                System.out.println("Please enter your role:"+ "\n1. Admin\n2. Normal User\n");
                int role = input.nextInt();
                User user;
                if(role == 1){
                    user = new Admin(name, email, password, "Admin");
                    newDatabase.addUser(user);
                    user.menu(newDatabase, user);
                }
                else if(role == 2){
                    user = new NormalUser(name, email, password, "Normal User");
                    newDatabase.addUser(user);
                    user.menu(newDatabase, user);
                }
                else{
                    System.out.println("Invalid role!");
                }
                //System.out.println("Registration successful!");
                //break;
            case 3:
                System.out.println("Thank you for using the Organisation Management System!");
                break;
            default:
                System.out.println("Invalid option!");
                break;
        }
        }while (option != 3);

    }
}