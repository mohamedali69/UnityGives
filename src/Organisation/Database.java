package Organisation;

import com.sun.tools.javac.Main;

import java.awt.print.Book;
import java.io.File;
import java.util.ArrayList;
public class Database {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<String> userNames = new ArrayList<String>();
    private ArrayList<Event> events  = new ArrayList<Event>();
    private ArrayList<String> eventNames = new ArrayList<String>();

    private File usersfile = new File("C:\\Users\\moham\\IdeaProjects\\UnityGives\\Data\\Users");
    private File folder = new File("C:\\Users\\moham\\IdeaProjects\\UnityGives\\Data");

    public Database() {
        if (!folder.exists()) {
            folder.mkdirs();
        }
        if (!usersfile.exists()) {
            try {
                usersfile.createNewFile();
            } catch (Exception e) {}
        }

        users = new ArrayList<User>();
    }
    public void addUser(User user) {
        users.add(user);
        userNames.add(user.getName());
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

    public void AddEvent(Event event){
        events.add(event);
        eventNames.add(event.getName());
    }


}
