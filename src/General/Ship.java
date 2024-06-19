package General;

public class Ship {
    private String name;
    private Notebook myNotebook;

    public Ship(){
        name = "No Name";
    }

    public Ship(String inputName){
        name = inputName;
        myNotebook = new Notebook();
        System.out.println(name);
    }

    public Notebook myNotebook(){
        return myNotebook;
    }

    public void setNotebook(Notebook inputNotebook){
        myNotebook = inputNotebook;
    }
}
