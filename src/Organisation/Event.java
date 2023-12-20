package Organisation;

public class Event {
    private String name;
    private String type;
    private String eventDate;
    private String location;
    private String description;
    public Event(){}
    public Event(String name, String type, String eventDate, String location, String description){
        this.name = name;
        this.type = type;
        this.eventDate = eventDate;
        this.location = location;
        this.description=description;
    }

    public String toString() {
        String text = "Event Name :" + name +
                "Event Type :" + type +
                "Event Date :" + eventDate +
                "Event location :" + location +
                "Event Description :" + description;
        return  text;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void menu(Database database, User user) {
    }
}
