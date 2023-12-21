package Organisation;

import java.util.Scanner;

public class AddEvent implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        Event event = new Event();
        System.out.println("Enter Event Name");
        String name = s.next();
        if (database.getEvent(name)>-1){
            System.out.println("There is an event with this name");
            user.menu(database, user);
            return;
        }else {
            event.setName(name);
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
            user.menu(database, user);
            s.close();
        }
    }
}
