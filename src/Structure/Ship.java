package Structure;

import Elements.Data;

public class Ship {
    private String name;
    private Data data = new Data();

    public Ship(){
        name = "No Name";
        String[] temp = {};
        Drawing[] temp2 = {};
        data.ShipRequirements = temp;
        data.ShipSketches = temp2;
    }

    public Ship(String inputName){
        name = inputName;
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
