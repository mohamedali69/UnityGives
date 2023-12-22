package Organisation;

import java.util.Scanner;

public class Search implements IOOperation{
    @Override
    public void oper(Database database, User user) {
        System.out.println("Enter event name");
        Scanner s = new Scanner(System.in);
        String eventname = s.next();
        int i = database.getEvent(eventname);
        if(i>-1){
            System.out.println("Event found");
            //System.out.println(database.getEvent(i).toString());
            user.menu(database,user);
        }else{
            System.out.println("Event doesn't exist");
            user.menu(database,user);
        }
    }
}
