package Structure;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Elements.Data;
import Elements.DataCache;
import Elements.GraphicsDatabase;
import Elements.ScreenScripts;

public abstract class SaveFiles {
    public static boolean createFile() {
        if(DataCache.myShip.retrieveData().ShipRequirements.length > 0){
            File file = new File("Saves\\data-" + DataCache.myShip.name() + ".txt");
            try {
                if(file.createNewFile()){
                    System.out.println("File Created");
                    if(DataCache.myShip != null){
                        saveFile();
                    }
                    return true;
                } else {
                    System.out.println("File Already Exists");
                }
            } catch (IOException e){
                e.printStackTrace();
            }
            return false;
        } else {
            return true;
        }
	}

	public static void saveFile(){
		File file = new File("Saves\\data-" + DataCache.myShip.name() + ".txt");
		try {
			FileWriter myWriter = new FileWriter(file);
			
			if(DataCache.myShip.retrieveData().ShipRequirements.length >= 0){
				myWriter.write(DataCache.myShip.toString());
			}

			myWriter.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}

	public static void readFromFile(){
        File savesDir = new File("Saves");
        File[] saves = savesDir.listFiles();
        if(saves != null){
            for(File save: saves){
                try{
                    Scanner sc = new Scanner(save);
        
                    //Load ship
                        ArrayList<String> reqs = new ArrayList<String>();
                        String name = sc.nextLine();
                        int reqNumber = Integer.parseInt(sc.nextLine());
                        for(int i = 0; i < reqNumber; i++){
                            reqs.add(sc.nextLine());
                        }
                        String type = sc.nextLine();
        
                    //Load notebook
                        ArrayList<NotebookEntry> entries = new ArrayList<NotebookEntry>();
                        int entriesNumber = Integer.parseInt(sc.nextLine());
                        for(int i = 0; i < entriesNumber; i++){
                            entries.add(new NotebookEntry(sc.nextLine(), sc.nextLine(), sc.nextLine()));
                        }
                    
                    //Load drawings
                        int numDrawings = Integer.parseInt(sc.nextLine());
                        Drawing[] drawings = new Drawing[numDrawings];
        
                        for(int i = 0; i < numDrawings; i++){
                            int numPoints = Integer.parseInt(sc.nextLine());
                            ArrayList<Coordinate> coords = new ArrayList<Coordinate> ();
                            for(int j = 0; j < numPoints; j++){
                                int x = sc.nextInt();
                                int y = sc.nextInt();
                                int r = sc.nextInt();
                                int g = sc.nextInt();
                                int b = sc.nextInt();
        
                                int size = sc.nextInt();
                                sc.nextLine();
        
                                Coordinate c = new Coordinate(x,y, new Color(r,g,b), size);
                                coords.add(c);
                            }
                            drawings[i] = new Drawing(coords);
                            int x = sc.nextInt();
                            int y = sc.nextInt();
                            drawings[i].setX(x);
                            drawings[i].setY(y);
                            drawings[i].constructImage();
                            sc.nextLine();
                        }
        
                    Data d = new Data(toStringArray(reqs), type, new Notebook(entries), drawings);
                    Ship s = new Ship(name, d);
        
                    // DataCache.myShip = s;
                    // ScreenScripts.PullNotebookPageToTextBox();
                    // Game.setScreen(GraphicsDatabase.S07);
                    DataCache.ships.add(s);
        
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No save files.");
        }
		//System.out.println(DataCache.coordinates1.getClass().getComponentType().getName());
	
	}

	public static String[] toStringArray(ArrayList<String> input){
		String[] s = new String[input.size()];
		for(int i = 0; i < input.size(); i ++){
			s[i] = input.get(i);
		}
		return s;
	}
}
