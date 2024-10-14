package Structure;

import java.util.ArrayList;

public class Notebook {
    private ArrayList<NotebookEntry> entries = new ArrayList<NotebookEntry>();

    private String defaultEntryTitle = "Welcome to your new notebook!";
    private String defaultEntryContents = "This is your design notebook, where you'll record each step in your design process. Access this notebook from any step in the design process and make your own entries!";

    public Notebook(){
        NotebookEntry defaultEntry = new NotebookEntry(defaultEntryTitle, defaultEntryContents);
        defaultEntry.recordMetadata();
        
        entries.add(defaultEntry);
    }

    public Notebook(ArrayList<NotebookEntry> _entries){
        entries = _entries;
    }

    public ArrayList<NotebookEntry> entries() {
        return entries;
    }

    public void addEntry(NotebookEntry _entry){
        entries.add(_entry);
    }

}
