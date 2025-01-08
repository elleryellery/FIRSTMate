package Structure;
import Elements.GraphicsDatabase;

public class NotebookEntry {
    private String name;
    private String entry;
    private String metadata;

    public NotebookEntry() {
        name = "Title";
        entry = "Type here!";
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
        metadata = (date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear() + " " + date.getHour() + ":" + date.getMinute());
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
