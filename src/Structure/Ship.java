package Structure;

import Elements.Data;

public class Ship {
    private String name;
    private Data data = new Data();

    public Ship(){
        name = "No Name";
    }

    public Ship(String inputName){
        name = inputName;
        System.out.println(name);
    }

    public Ship(String _name, Data _data){

    }

    public Notebook myNotebook(){
        return data.Notebook;
    }

    public Data retrieveData(){
        return data;
    }

}
