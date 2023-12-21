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
                new DeleteAllData(),
                new ViewVolunteering(),
                new AddVolunteering(),
                new Exit()
    };
    }

    @Override
    public void menu(Database database, User user) {
        System.out.print("1. View Events\n");
        System.out.print("2. Add Events\n");
        System.out.print("3. Delete Event\n");
        System.out.print("4. Search\n");
        System.out.print("5. Delete All Data\n");
        System.out.print("6. View Volunteer\n");
        System.out.print("7. Add Volunteer\n");
        System.out.print("8. Exit\n");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        this.operations[n-1].oper(database, user);
    }
    public String toString(){
        return name+"<N/>"+email+"<N/>"+password+"<N/>"+"Admin";
    }
}
