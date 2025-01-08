package Structure;

import java.util.ArrayList;

public class Notebook {
    private ArrayList<NotebookEntry> entries = new ArrayList<NotebookEntry>();

    private String defaultEntryTitle = "Welcome!";
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

    public void addEntry(int index, NotebookEntry _entry){
        entries.add(index, _entry);
    }

    public void replaceEntry(int index, NotebookEntry entry){
        if(index < entries.size()){
            entries.remove(index);
            entries.add(index, entry);
        } else {
            addEntry(entry);
        }
    }

    public void deleteEntry(int index){
        if(entries.size()>1){
            entries.remove(index);
        }
    }

    public String toString(){
        String s = entries.size() + "\n";
        for(NotebookEntry e: entries){
            s += e.name() + "\n";
            s += e.metadata() + "\n";
            s += e.entry() + "\n";
        }
        return s;
    }

}
