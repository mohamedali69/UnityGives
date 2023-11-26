package Organisation;

public class NormalUser extends User {
    public NormalUser(String name, String email, String password, String role) {
        super(name, email, password, role);
    }

    @Override
    public void menu() {
        System.out.print("1. View Event\n");
        System.out.print("2. Exit\n");
    }
}