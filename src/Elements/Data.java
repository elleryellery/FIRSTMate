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

    public Notebook Notebook(){
        return Notebook;
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
}
