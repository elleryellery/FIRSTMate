package Structure;
import Elements.GraphicsDatabase;

public class NotebookEntry {
    private String name;
    private String entry;
    private String metadata;

    public NotebookEntry() {
        name = "Title";
        entry = "Type here!";
        System.out.println("empty constructor call");
    }

    public NotebookEntry(String inputName, String inputEntry){
        name = inputName;
        entry = inputEntry;
    }

    
    public NotebookEntry(String inputName, String metadata, String inputEntry){
        name = inputName;
        entry = inputEntry;
        this.metadata = metadata;
    }

    public String name(){
        return name;
    }

    public String entry() {
        return entry;
    }

    public String metadata(){
        return metadata;
    }

    public void recordMetadata(){
        java.time.LocalDateTime date = java.time.LocalDateTime.now();
        int hour = date.getHour();
        int minute = date.getMinute();
        String formattedMinute = "";
        if(minute < 10){
            formattedMinute = "0" + minute;
        } else {
            formattedMinute += minute;
        }
        if(hour > 12) {
            hour -= 12;
            formattedMinute += "PM";
        } else {
            formattedMinute += "AM";
        }
        metadata = (date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear() + " " + hour + ":" + formattedMinute);
    }

    public String toString(){
        return "\n\n(" + metadata + ")\n" + name + "\n" + entry;
    }

    public void update(){
        name = GraphicsDatabase.I02.contents();
        entry = GraphicsDatabase.I03.contents();
        recordMetadata();
    }
}
