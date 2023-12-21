package Organisation;

import java.util.Scanner;

public class AddVolunteering implements IOOperation{
    public void oper(Database database, User user) {
        Volunteering volunteering = new Volunteering();
        System.out.println("Enter event name:");
        Scanner s = new Scanner(System.in);
        String eventName = s.next();
        int i = database.getEvent(eventName);
        if (i<=-1) {
            System.out.println("Event not found");
            user.menu(database, user);
        }else {
            Event event = database.getEvent(i);
            volunteering.setEvent(database.getEvent(i));
            volunteering.setUser(user);
            System.out.println("Enter donation:");
            volunteering.setDonation(s.next());
            database.addVolunteering(volunteering, event,i);
            System.out.println("Volunteering added successfully!");
        }
        user.menu(database, user);
    }
}
