package General;

public class Field {
    public String name;
    public String entry;

    public Field() {

    }

    public Field(String inputName, String inputEntry){
        name = inputName;
        entry = inputEntry;
    }

    public String name(){
        return name;
    }

    public String entry() {
        return entry;
    }
}
