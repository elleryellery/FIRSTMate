package Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import Structure.*;

public class Data {

    public String[] ShipRequirements;
    public String ShipType;
    public Notebook Notebook;
    public String ShipName;
    public Drawing[] ShipSketches;

    public Data(){
        Notebook = new Notebook();
    }

    public Data(String[] shipRequirements, String shipType, Notebook notebook, Drawing[] shipSketches){
        ShipRequirements = shipRequirements;
        ShipType = shipType;
        Notebook = notebook;
        ShipSketches = shipSketches;
    }

    public Notebook Notebook(){
        return Notebook;
    }

    public void setNotebook(Notebook notebook){
        Notebook = notebook;
    }

    public void setShipRequirements(String[] customRequirements){
        String[] defaultRequirements = {"Deck", "Steering", "Flag"};
        ShipRequirements = Stream.concat(Arrays.stream(defaultRequirements), Arrays.stream(customRequirements)).toArray(String[]::new);

        ShipSketches = new Drawing[ShipRequirements.length];
        for(int i = 0; i < ShipSketches.length; i++){
            ShipSketches[i] = new Drawing();
        }
    }

    public boolean hasAllDrawings(){
        for(Drawing d: ShipSketches){
            if(d.isEmpty()){
                return false;
            }
        }
        return true;
    }

    public String toString(){
        String s = "";
        s += ShipRequirements.length + "\n";
        for(String r: ShipRequirements){
            s += r + "\n";
        }
        s += ShipType + "\n";
        s += Notebook;
        return s;
    }

    public void drawShip(int x, int y){
        for(Drawing d: ShipSketches){
            Game.Graphics().drawImage(d.asPicture(),d.x() + x, d.y() + y, d.width(), d.height(), null);
            if(DataCache.debug){
                Game.Graphics().drawRect(d.x() + x, d.y() + y, d.width(), d.height());
            }
        }
    }

    public void makeSketchCopy(){
        Drawing[] sketches = DataCache.myShip.retrieveData().ShipSketches;
        DataCache.sketchCopy.clear();
        ArrayList<Coordinate> temp = new ArrayList <Coordinate> ();
        for(Drawing d: sketches){
            for(Coordinate c: d.getPoints()){
                temp.add(new Coordinate(c.x() + d.x() - d.x2(), c.y() + d.y() - d.y2(), c.color(), c.size()));
            }
            Drawing copy = new Drawing(temp);
            copy.giveDraggable(d.draggable());
            copy.constructImage();
            copy.setX(d.x());
            copy.setY(d.y());
            copy.constructImage();
            DataCache.sketchCopy = temp;
        }
    }

    public void reconstructCopy(){
        for(Drawing d: DataCache.sketchCopy){
            d.constructImage();
        }
    }

    public void drawShipCopy(int x, int y){
        // for(Drawing d: DataCache.sketchCopy){
        //     Game.Graphics().drawImage(d.asPicture(),d.x() + x, d.y() + y, d.width(), d.height(), null);
        //     if(DataCache.debug){
        //         Game.Graphics().drawRect(d.x() + x, d.y() + y, d.width(), d.height());
        //     }
        // }
        for(Drawing d: DataCache.sketchCopy){
            for(Coordinate c: d.getPoints()){
                c.drawCoordinate(c.x() + d.x() - d.x2() + x, c.y() + d.y() - d.y2() + y);
                if(DataCache.debug){
                    Game.Graphics().setColor(c.color());
                    Game.Graphics().drawRect(c.x() + d.x() - d.x2() + x, c.y() + d.y() - d.y2() + y,c.size(),c.size());
                }
            }
        }
        Collections.sort()
    }
}
