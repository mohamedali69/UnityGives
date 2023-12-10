package Organisation;

import java.util.Scanner;

public class NormalUser extends User {
    public NormalUser(String name, String email, String password, String role) {
        super(name, email, password, role);
        this.operations = new IOOperation[]{
          new ViewEvents(),
          new Search(),
          new ParticipateEvent()
        };
    }

    @Override
    public void menu(Database database, User user) {
        System.out.print("1. View Events\n");
        System.out.print("2. Search Events\n");
        System.out.print("3. Participate to an event\n");
        System.out.print("4. Exit\n");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].oper(database, user);
    }
}