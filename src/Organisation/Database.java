package Organisation;

import com.sun.tools.javac.Main;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
    private void getUsers() {
        String text1 = "";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(usersfile));
            String s1;
            while ((s1 = br1.readLine()) !=null) {
                text1 = text1 + s1;
            }
            br1.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        if (!text1.matches("") || !text1.isEmpty()) {
            String[] a1 = text1.split("<NewUser/>");
            for (String s : a1) {
                String[] a2 = s.split("<N/>");
                if (a2[3].matches("Admin")) {
                    User user = new Admin(a2[0], a2[1], a2[2], "Admin");
                    users.add(user);
                    userNames.add(user.getName());
                } else {
                    User user = new NormalUser(a2[0], a2[1], a2[2], "Normal User");
                    users.add(user);
                    userNames.add(user.getName());
                }
            }
        }
    }
    public void AddEvent(Event event){
        events.add(event);
        eventNames.add(event.getName());
    }


}
