package Organisation;

import java.util.ArrayList;

public class ViewEvents implements  IOOperation{
    @Override
    public void oper(Database database, User user) {
        ArrayList<Event> events = database.getAllEvents();
        System.out.println("Name\t\tType\t\tDate\t\tLocation\t\tDescription");
        for (Event event : events) {
            System.out.println(event.getName() + "\t\t\t" + event.getType() + "\t\t\t" + event.getEventDate() + "\t\t\t" + event.getLocation() + "\t\t\t" + event.getDescription());
        }
        System.out.println();
        user.menu(database, user);
    }
}
