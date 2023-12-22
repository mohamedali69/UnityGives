package Organisation;

import java.util.Scanner;

public class DeleteEvent implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter event name");
        String eventname = s.next();
        int i = database.getEvent(eventname);
        if(i>-1){
            database.deleteEvent(i);
            System.out.println("Event deleted successfully!");
            user.menu(database,user);
        }else{
            System.out.println("Event doesn't exist");
            user.menu(database,user);
        }
    }
}
