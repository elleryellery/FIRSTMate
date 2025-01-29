package Structure;

import Elements.Data;
import Elements.ScreenScripts;

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
                s += c.x() + " " + c.y() + " " + c.color().getRed() + " " + c.color().getGreen() + " " + c.color().getBlue() + " " + c.size() + "\n";
            }
            if(d.draggable() == null){
                ScreenScripts.convertSketchesToDraggables();
            }

            s += d.draggable().x() + " " + d.draggable().y() + "\n";
        }
        
        return s;
    }

    public String name(){
        return name;
    }

    public int numPoints(){
        int numPoints = 0;
        for(Drawing d: data.ShipSketches){
            numPoints += d.getPoints().size();
        }

        return numPoints;
    }

    public boolean sinks(){
        int threshold = 15000;
        return numPoints() > threshold;
    }

}
