package Structure;

public class NotebookEntry {
    private String name;
    private String entry;
    private String metadata;

    public NotebookEntry() {

    }

    public NotebookEntry(String inputName, String inputEntry){
        name = inputName;
        entry = inputEntry;
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
}
