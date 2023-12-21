package Organisation;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewVolunteering implements IOOperation{

    @Override
    public void oper(Database database, User user) {
        System.out.println("\nEnter event name:");
        Scanner s = new Scanner(System.in);
        String eventName = s.next();
        int i = database.getEvent(eventName);
        if (i>=-1) {
            ArrayList<Volunteering> Volunteerings = new ArrayList<Volunteering>();
            for (Volunteering volunteering : database.getAllVolunteerings()) {
                if (volunteering.getEvent().getName().equals(eventName)) {
                    Volunteerings.add(volunteering);
                }
            }
            System.out.println("Event\t\tUser\t\tDonation");
            for (Volunteering volunteering : Volunteerings) {
                System.out.println(volunteering.getEvent().getName() + "\t\t" + volunteering.getUser().getName() + "\t\t" + volunteering.getDonation());
            }
        }
        else{
            System.out.println("Event not found");
        }
        user.menu(database, user);
    }
}
