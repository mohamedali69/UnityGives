package Organisation;

public class Admin extends User {
    public Admin(String name, String email, String password, String role) {
        super(name, email, password, role);
    }

    @Override
    public void menu() {
        System.out.print("Admin Menu\n");
    }
}
