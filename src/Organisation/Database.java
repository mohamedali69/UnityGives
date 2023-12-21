package Organisation;

import com.sun.tools.javac.Main;

import java.awt.print.Book;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
public class Database {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<String> userNames = new ArrayList<String>();
    private ArrayList<Event> events  = new ArrayList<Event>();
    private ArrayList<String> eventNames = new ArrayList<String>();
    private ArrayList<Volunteering> volunteerings = new ArrayList<Volunteering>();
    private ArrayList<String> volunteeringNames = new ArrayList<String>();


    private File usersfile = new File("C:\\Users\\moham\\IdeaProjects\\UnityGives\\Data\\Users");
    private File eventsFile = new File("C:\\Users\\moham\\IdeaProjects\\UnityGives\\Data\\Events");
    private File volunteeringsFile = new File("C:\\Users\\moham\\IdeaProjects\\UnityGives\\Data\\Volunteering");
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
        if(!eventsFile.exists()) {
            try {
                eventsFile.createNewFile();
            } catch (Exception e) {}
        }
        if (!volunteeringsFile.exists()){
            try{
                volunteeringsFile.createNewFile();
            }catch (Exception e){
        }}
        users = new ArrayList<User>();
        userNames = new ArrayList<String>();
        events = new ArrayList<Event>();
        eventNames = new ArrayList<String>();
        getUsers();
        getEvents();
        getVolunteerings();
    }
    public void addUser(User user) {
        users.add(user);
        userNames.add(user.getName());
        saveUsers();
    }
    public User getUser(int found) {
        return users.get(found);
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
                System.out.println(a2);
                if (a2.length >= 4) {
                if (a2[3].matches("Admin")) {
                    User user = new Admin(a2[0], a2[1], a2[2], "Admin");
                    users.add(user);
                    userNames.add(user.getName());
                }else {
                    User user = new NormalUser(a2[0], a2[1], a2[2], "Normal User");
                    users.add(user);
                    userNames.add(user.getName());
                }
                }
                 
            }
        }
    }
    private void saveUsers() {
		String text1 = "";
		for (User user : users) {
			text1 = text1 + user.toString()+"<NewUser/>\n";
		}
		try {
			PrintWriter pw = new PrintWriter(usersfile);
			pw.print(text1);
			pw.close();
		} catch  (Exception e) {
			System.err.println(e.toString());
		}
	}
	
    private void saveEvents() {
        String text1 = "";
        for (Event event : events) {
            text1 = text1 + event.toString()+"<NewEvent/>\n";
        }
        try {
            PrintWriter pw = new PrintWriter(eventsFile);
            pw.print(text1);
            pw.close();
        } catch  (Exception e) {
            System.err.println(e.toString());
        }
    }
    private void getEvents() {
        String text1 = "";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(eventsFile));
            String s1;
            while ((s1 = br1.readLine()) !=null) {
                text1 = text1 + s1;
            }
            br1.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        if (!text1.matches("") || !text1.isEmpty()) {
            String[] a1 = text1.split("<NewEvent/>");
            for (String s : a1) {
                Event event = parseEvent(s);
                events.add(event);
                eventNames.add(event.getName());
            }
        }
    }

    public Event parseEvent(String s) {
        String[] a = s.split("<N/>");
        Event event = new Event();
        if(a.length >= 4) {
        event.setName(a[0]);
        event.setType(a[1]);
        event.setEventDate(a[2]);
        event.setLocation(a[3]);
        event.setDescription(a[4]);
        }
        return event;
    }
    public void AddEvent(Event event) {
        events.add(event);

        saveEvents();
    }
    public ArrayList<Event> getAllEvents() {
        return events;
    }
    public int getEvent(String eventNames) {
        int i = -1;
        for (Event event : events) {
            if (event.getName().matches(eventNames)) {
                i = events.indexOf(event);
            }
        }
        return i;
    }
    public Event getEvent(int i) {
        return events.get(i);
    }

    public void deleteEvent(int i) {
        events.remove(i);
        eventNames.remove(i);
        saveEvents();
    }
    public void deleteAllData() {
        if (usersfile.exists()) {
            try {
                usersfile.delete();
            } catch (Exception e) {}
        }
        if (eventsFile.exists()) {
            try {
                eventsFile.delete();
            } catch (Exception e) {}
        }
    }
    public void addVolunteering(Volunteering volunteering, Event event, int eventindex) {
        volunteerings.add(volunteering);
        events.set(eventindex, event);
        saveVolunteerings();
        saveEvents();
    }
    private void saveVolunteerings() {
        String text1 = "";
        for (Volunteering volunteering : volunteerings) {
            text1 = text1 + volunteering.toString()+"<NewVolunteering/>\n";
        }
        try {
            PrintWriter pw = new PrintWriter(volunteeringsFile);
            pw.print(text1);
            pw.close();
        } catch  (Exception e) {
            System.err.println(e.toString());
        }
    }
    private void getVolunteerings() {
        String text1 = "";
        try {
            BufferedReader br1 = new BufferedReader(new FileReader(volunteeringsFile));
            String s1;
            while ((s1 = br1.readLine()) !=null) {
                text1 = text1 + s1;
            }
            br1.close();
        } catch (Exception e) {
            System.err.println(e.toString());
        }

        if (!text1.matches("") || !text1.isEmpty()) {
            String[] a1 = text1.split("<NewOrder/>");
            for (String s : a1) {
                Volunteering volunteering = paseVolunteering(s);
                volunteerings.add(volunteering);
            }
        }
    }
    private User getUserByName(String name) {
        User u = new NormalUser("","","","");
        for (User user : users) {
            if (user.getName().matches(name)) {
                u = user;
                break;
            }
        }
        return u;
    }
    private Volunteering paseVolunteering(String s) {
        String[] a = s.split("<N/>");
        Volunteering order = new Volunteering(events.get(getEvent(a[0])), getUserByName(a[1]),
                a[2]);
        return order;
    }

    public ArrayList<Volunteering> getAllVolunteerings() {
        return volunteerings;
    }
}
