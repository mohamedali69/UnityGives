package Organisation;

public class NormalUser extends User {
    public NormalUser(String name, String email, String password, String role) {
        super(name, email, password, role);
    }

    @Override
    public void menu() {
        System.out.print("Normal User Menu\n");
    }
}