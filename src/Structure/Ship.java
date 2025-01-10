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
        name = _name;
        data = _data;
    }

    public Notebook myNotebook(){
        return data.Notebook;
    }

    public Data retrieveData(){
        return data;
    }

    public String toString(){
        String s = name + "\n" + data + "\n";
        s += data.ShipSketches.length + "\n";
        for(Drawing d: data.ShipSketches){
            s += d.getPoints().size() + "\n";
            for(Coordinate c: d.getPoints()){
                s += c.x() + "\n" + c.y() + "\n" + c.color.getRed() + "\n" + c.color.getGreen() + "\n" + c.color.getBlue() + "\n" + c.size + "\n";
            }
        }
        return s;
    }

    public String name(){
        return name;
    }

}
