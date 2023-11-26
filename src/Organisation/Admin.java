package Organisation;

public class Admin extends User {
    public Admin(String name, String email, String password, String role) {
        super(name, email, password, role);
    }

    @Override
    public void menu() {
        System.out.print("1. View Events\n");
        System.out.print("2. Add Events\n");
        System.out.print("3. View Team\n");
        System.out.print("4. Add Team\n");
        System.out.print("5. View Volunteer\n");
        System.out.print("6. Add Volunteer\n");
        System.out.print("7. Exit\n");
    }
}
