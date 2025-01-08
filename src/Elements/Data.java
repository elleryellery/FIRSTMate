package Elements;

import java.util.Arrays;
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
        s += Notebook + "\n";
        return s;
    }
}
