package Organisation;

import java.util.Scanner;

public class AddEvent implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        Event event = new Event();
        System.out.println("Enter Event Name");
        event.setName(s.next());
        System.out.println("Enter Event Type");
        event.setType(s.next());
        System.out.println("Enter Event Date");
        event.setEventDate(s.next());
        System.out.println("Enter Event Location");
        event.setLocation(s.next());
        System.out.println("Enter Event Description");
        event.setDescription(s.next());
        database.AddEvent(event);
        System.out.println("Event Added Successfully");
        event.menu(database, user);

    }
}
