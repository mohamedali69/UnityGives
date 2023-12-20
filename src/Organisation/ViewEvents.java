package Organisation;

import java.util.ArrayList;

public class ViewEvents implements  IOOperation{
    @Override
    public void oper(Database database, User user) {
        ArrayList<Event> events = database.getAllEvents();
        System.out.println("Name\tType\tDate\tLocation\tDescription");
        for (Event event : events) {
            System.out.println(event.getName() + "\t" + event.getType() + "\t" + event.getEventDate() + "\t" + event.getLocation() + "\t" + event.getDescription());
        }
        System.out.println();
        user.menu(database, user);
    }
}
