package Organisation;
import java.util.ArrayList;
public class Database {
    ArrayList<User> users = new ArrayList<User>();
    ArrayList<String> userNames = new ArrayList<String>();
    ArrayList<String> userEmails = new ArrayList<String>();
    ArrayList<String> userPasswords = new ArrayList<String>();
    ArrayList<String> userRoles = new ArrayList<String>();

    public void addUser(User user) {
        users.add(user);
        userNames.add(user.getName());
        userEmails.add(user.getEmail());
        userPasswords.add(user.getPassword());
        userRoles.add(user.getRole());
    }
    public int login(String email, String password) {
        int found = -1;
        for (User s : users) {
            if (s.getEmail().matches(email) && s.getPassword().matches(password)) {
                found= users.indexOf(s);
                break;
            }
        }
        return found;
    }
    public User getUser(int found) {
        return users.get(found);
    }
}
