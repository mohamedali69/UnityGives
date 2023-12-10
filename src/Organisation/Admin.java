package Organisation;

import java.util.Scanner;

public class Admin extends User {

    public Admin(String name, String email, String password, String role) {
        super(name, email, password, role);
        this.operations = new IOOperation[] {
                new ViewEvents(),
                new AddEvent(),
                new DeleteEvent(),
                new Search(),
                new ViewDonators(),
                new Exit()
    };
    }

    @Override
    public void menu(Database database, User user) {
        System.out.print("1. View Events\n");
        System.out.print("2. Add Events\n");
        System.out.print("3. View Team\n");
        System.out.print("4. Add Team\n");
        System.out.print("5. View Volunteer\n");
        System.out.print("6. Add Volunteer\n");
        System.out.print("7. Exit\n");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].oper(database, user);
    }
}
