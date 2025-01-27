package Elements;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
        }

        ArrayList<Coordinate> sorted = new ArrayList<Coordinate> ();

        Collections.sort(sorted, new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate a, Coordinate b) {
                int cmp0 = a.x() - (b.x());
                if (cmp0 != 0) {
                    return cmp0;
                }
                int cmp1 = a.y() - b.y();
                if (cmp1 != 0) {
                    return cmp1;
                }
                return 0;
            }
        });

        for(int i = sorted.size() - 1; i > 0; i--){
            Coordinate a = sorted.get(i);
            Coordinate b = sorted.get(i-1);
            if(a.x() == b.x() && a.y() == b.y() && a.size() == b.size()){
                temp.remove(b);
            }
        }

        DataCache.sketchCopy = temp;

    }

    public void drawShipCopy(int x, int y){
        for(Coordinate c: DataCache.sketchCopy){
            c.drawCoordinate(c.x() + x, c.y() + y);
        }
    }

    public int checkDestruction(){
        ArrayList<Coordinate> sorted = DataCache.sketchCopy;

        Collections.sort(sorted, new Comparator<Coordinate>() {
            @Override
            public int compare(Coordinate a, Coordinate b) {
                int cmp1 = a.y() - b.y();
                if (cmp1 != 0) {
                    return cmp1;
                }
                return 0;
            }
        });

        for(int i = (int)(sorted.size() * 0.2); i < sorted.size() - (int)(sorted.size() * 0.2); i++){
            if(sorted.get(i).y() != sorted.get(i-1).y() && sorted.get(i).y() != sorted.get(i+1).y()){
                return sorted.get(i).y();
            } else {
                i += 1;
            }
        }
        return 0;
    }
        
}
