package Organisation;

public class Volunteering {
    private Event event;
    private User user;
    private String donation;

    public Volunteering(Event event, User user, String donation){
        this.event = event;
        this.user = user;
        this.donation = donation;
    }

    public Volunteering(){}
    public Event getEvent() {
        return event;
    }

    public User getUser() {
        return user;
    }

    public String getDonation() {
        return donation;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setDonation(String donation) {
        this.donation = donation;
    }
//    public String toString() {
//        return "Event name:" +event.getName()+"\n"+
//                "Username:" +user.getName()+"\n"+
//                "Donation" + donation;
//    }
    public String toString(){
        return event.getName()+"<N/>"+user.getName()+"<N/>"+donation;
    }
}
