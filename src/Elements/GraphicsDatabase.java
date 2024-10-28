package Elements;
import java.awt.Color;

import Structure.*;

public abstract class GraphicsDatabase {
    public static Button B01, B02, B03, B04, B05, B06, B07, B08, B09, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23;

    public static TextInput I01, I02, I03, I04;

    public static ConditionalButton C01, C02, C03, C04, C05, C06, C07, C08, C14, C15, C16, C17, C18, C19, C20, C21, C22, C23, C24, C25, C26, C27, C28, C29, C30, C31, C32, C33, C34, C35, C36, C44, C45, C46, C47, C48;

    public static Screen S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12, S13, S14, S15, S16, S17, S18, S19, S20;

    public static Color black, white, yellow, lightBlue, red, turquoise, purple, hotPink, orange, darkPurple, lightGreen, lightPink, skyBlue, green, burgundy, blue, pink;

    public static void init(){
        B01 = new Button("B01", 1130, 0, 50, 50, () -> {Game.setScreen(S16);}); //Settings
        B02 = new Button("B02", 470, 400, 250, 78, () -> {Game.setScreen(S02);}); //New Design
        B03 = new Button("B03", 0, 0, 50, 50, () -> {Game.setScreen(S01);}); //Home TODO Save progress
        B04 = new Button("B04", 470, 400, 250, 78, () -> { //Create ship
            Game.setScreen(S03);
            DataCache.myShip = new Ship(I01.contents());
        });
        B05 = new Button("B05", 170, 200, 235, 281, () -> { //Cruiser
            String[] components = {         
                "Restaurant", "Movie Theater", "Party Room", "Fun Area 1", "Fun Area 2"
            };
            DataCache.myShip.retrieveData().setShipRequirements(components);
            DataCache.myShip.retrieveData().ShipType = "Cruiser";
            Game.setScreen(S05);
        });
        B06 = new Button("B06", 470, 200, 235, 281, () -> { //Pearl
            String[] components = {            
                "Cannons", "A way to board other ships", "Treasure Room", "Fighting mechanism"
            };
            DataCache.myShip.retrieveData().setShipRequirements(components);
            DataCache.myShip.retrieveData().ShipType = "The Pearl";
            Game.setScreen(S06);
        });
        B07 = new Button("B07", 770, 200, 235, 281, () -> { //Ghoul
            String[] components = {            
                "Trap #1", "Trap #2", "Protective Layer", "Scary Flag"
            };
            DataCache.myShip.retrieveData().setShipRequirements(components);
            DataCache.myShip.retrieveData().ShipType = "The Ghoul";
            Game.setScreen(S04);
        });
        B08 = new Button("B08", 721, 428, 250, 78, () -> {
            String type = DataCache.myShip.retrieveData().ShipType;
            NotebookEntry entry = new NotebookEntry();
            if(type.equals("Cruiser")){
                entry = new NotebookEntry("Your New Cruiser", 
                        "The cruiser is made for pirate fun!" + TextInterpreter.newLineKey +
                        "As a cruiser, your ship will be designed to give pirate riders a great time. Your cruiser must include:" + TextInterpreter.newLineKey +
                        "Your cruiser must include:" + TextInterpreter.newLineKey +
                        "  ‣   A restaurant" + TextInterpreter.newLineKey +
                        "  ‣   A movie theater" + TextInterpreter.newLineKey +
                        "  ‣   A party room" + TextInterpreter.newLineKey +
                        "  ‣   At least two other fun areas of your choosing!");
            } else if(type.equals("The Pearl")){
                entry = new NotebookEntry("Your New Pearl",
                        "The pearl is a classic pirate ship, focusing mostly on playing offense on the seas." + TextInterpreter.newLineKey +
                        "As a pearl, your ship will be designed to pillage and raid." + TextInterpreter.newLineKey +
                        "Your pearl must include:" + TextInterpreter.newLineKey +
                        "  ‣   At least three cannons" + TextInterpreter.newLineKey +
                        "  ‣   A way to board other ships" + TextInterpreter.newLineKey +
                        "  ‣   A treasure room for stolen goodies" + TextInterpreter.newLineKey +
                        "  ‣   Your own creative design for fighting other pirate ships");
            } else if(type.equals("The Ghoul")){
                entry = new NotebookEntry("Your New Ghoul",
                        "The Ghoul is a defensive ship filled with ghostly inhabitants." + TextInterpreter.newLineKey +
                        "As a Ghoul, your ship will be designed to fend off invaders and protect treasure." + TextInterpreter.newLineKey +
                        "Your Ghoul must include:" + TextInterpreter.newLineKey +
                        "  ‣   At least two traps" + TextInterpreter.newLineKey +
                        "  ‣   A protective layer for the ship’s deck" + TextInterpreter.newLineKey +
                        "  ‣   A scary flag of your own design to intimidate invaders");
            }
            entry.recordMetadata();
            DataCache.myShip.retrieveData().Notebook.replaceEntry(2, entry);
            Game.setScreen(S07);
            ScreenScripts.PullNotebookPageToTextBox();
        });
        B09 = new Button("B09", 0, 0, 50, 50, () -> {Game.previousScreen();}); //Back/Previous
        
        B10 = new Button("B10", 0, 561, 50, 50, () -> {//TODO Check ship and provide relevant animation
            Game.setScreen(S17);
        });

        B11 = new Button("B11", 721, 428, 250, 78, () -> {
            NotebookEntry entry = new NotebookEntry(I02.contents(), I03.contents());
            entry.recordMetadata();
            DataCache.myShip.retrieveData().Notebook.addEntry(entry);
            Game.setScreen(S14);
        });

        B12 = new Button("B12", 1095, 78, 80, 80, () -> {
            Game.setScreen(S15);
        });

        B19 = new Button("B20", 719, 533, 50, 50, () -> { //TODO Save notebook entry
            Game.setScreen(S08);
        });

        B20 = new Button("B20", 493, 532, 250, 78, () -> { //TODO Save notebook entry
            Game.setScreen(S01);
            DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber-1).update();
        });

        B21 = new Button("B21", 55, 561, 50, 50, () -> {//TODO Check ship and provide relevant animation
            Game.setScreen(S18);
        });

        B22 = new Button("B22", 809, 290, 50, 50, () -> {
            DataCache.myShip.myNotebook().addEntry(DataCache.pageNumber+1, new NotebookEntry());
        });

        B23 = new Button("B23", 283, 290, 50, 50, () -> {
            if(DataCache.pageNumber > 0){
                DataCache.pageNumber --;
            }
            DataCache.myShip.myNotebook().deleteEntry(DataCache.pageNumber + 1);
            ScreenScripts.PullNotebookPageToTextBox();
        });

        C01 = new ConditionalButton("C01", 100, 100, 50, 50, () -> (Settings.enabledMusic), () -> {
            Settings.enabledMusic = !Settings.enabledMusic;
        });

        C04 = new ConditionalButton("C04", 395, 535, 50, 50, () -> !(DataCache.pageNumber > 0), () -> { //Back
            if(DataCache.pageNumber > 0){
                DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber).update();
                DataCache.pageNumber --;
                ScreenScripts.PullNotebookPageToTextBox();
            }
        });

        C03 = new ConditionalButton("C03", 664, 535, 50, 50, () -> !(DataCache.myShip == null || DataCache.pageNumber < DataCache.myShip.retrieveData().Notebook().entries().size() -1), () -> {
            if(DataCache.pageNumber < DataCache.myShip.retrieveData().Notebook().entries().size() -1){
                DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber).update();
                DataCache.pageNumber ++;
                ScreenScripts.PullNotebookPageToTextBox();
            }
        });

        C05 = new ConditionalButton("C05", 760, 70, 50, 50, () -> !(DataCache.componentIndex < DataCache.myShip.retrieveData().ShipRequirements.length - 1), () -> { //Next component
            if(DataCache.componentIndex < DataCache.myShip.retrieveData().ShipRequirements.length - 1){
                DataCache.componentIndex ++;
                DataCache.drawing = DataCache.myShip.retrieveData().ShipSketches[DataCache.componentIndex].getPoints();
            }
            System.out.println(DataCache.componentIndex);
        });
        
        C06 = new ConditionalButton("C06", 519, 70, 50, 50, () -> !(DataCache.componentIndex > 0), () -> { //Previous component
            if(DataCache.componentIndex > 0){
                DataCache.componentIndex --;
                DataCache.drawing = DataCache.myShip.retrieveData().ShipSketches[DataCache.componentIndex].getPoints();
            }
            System.out.println(DataCache.componentIndex);
        });

        C07 = new ConditionalButton("C07", 470, 125, 250, 78, () -> (false), () -> { //TODO add condition
            Game.setScreen(S19);
        });

        C14 = new ConditionalButton("C14", 15, 150, 75, 75, () -> (DataCache.penColor == black), () -> {
            DataCache.penColor = black;
        });

        C15 = new ConditionalButton("C15", 90, 150, 75, 75, () -> (DataCache.penColor == white), () -> {
            DataCache.penColor = white;
        });

        C16 = new ConditionalButton("C16", 165, 150, 75, 75, () -> (DataCache.penColor == yellow), () -> {
            DataCache.penColor = yellow;
        });

        C17 = new ConditionalButton("C17", 15, 225, 75, 75, () -> (DataCache.penColor == lightBlue), () -> {
            DataCache.penColor = lightBlue;
        });

        C18 = new ConditionalButton("C18", 90, 225, 75, 75, () -> (DataCache.penColor == red), () -> {
            DataCache.penColor = red;
        });

        C19 = new ConditionalButton("C19", 165, 225, 75, 75, () -> (DataCache.penColor == turquoise), () -> {
            DataCache.penColor = turquoise;
        });

        C20 = new ConditionalButton("C20", 15, 300, 75, 75, () -> (DataCache.penColor == purple), () -> {
            DataCache.penColor = purple;
        });

        C21 = new ConditionalButton("C21", 90, 300, 75, 75, () -> (DataCache.penColor == hotPink), () -> {
            DataCache.penColor = hotPink;
        });

        C22 = new ConditionalButton("C22", 165, 300, 75, 75, () -> (DataCache.penColor == orange), () -> {
            DataCache.penColor = orange;
        });

        C23 = new ConditionalButton("C23", 15, 375, 75, 75, () -> (DataCache.penColor == darkPurple), () -> {
            DataCache.penColor = darkPurple;
        });

        C24 = new ConditionalButton("C24", 90, 375, 75, 75, () -> (DataCache.penColor == lightGreen), () -> {
            DataCache.penColor = lightGreen;
        });

        C25 = new ConditionalButton("C25", 165, 375, 75, 75, () -> (DataCache.penColor == lightPink), () -> {
            DataCache.penColor = lightPink;
        });

        C26 = new ConditionalButton("C26", 15, 450, 75, 75, () -> (DataCache.penColor == skyBlue), () -> {
            DataCache.penColor = skyBlue;
        });

        C27 = new ConditionalButton("C27", 90, 450, 75, 75, () -> (DataCache.penColor == green), () -> {
            DataCache.penColor = green;
        });

        C28 = new ConditionalButton("C28", 165, 450, 75, 75, () -> (DataCache.penColor == burgundy), () -> {
            DataCache.penColor = burgundy;
        });

        C31 = new ConditionalButton("C31", 120, 108, 40, 40, () -> (DataCache.penType.equals("Scribble")), () -> {
            DataCache.penType = "Scribble";
        });

        C32 = new ConditionalButton("C32", 160, 108, 40, 40, () -> (DataCache.penType.equals("Erase")), () -> {
            DataCache.penType = "Erase";
        });

        C33 = new ConditionalButton("C33", 200, 108, 40, 40, () -> (DataCache.penType.equals("Line")), () -> {
            DataCache.penType = "Line";
        });

        C34 = new ConditionalButton("C34", 15, 108, 35, 35, () -> DataCache.penSize == Constants.largePen, () -> {
            DataCache.penSize = Constants.largePen;
        });

        C35 = new ConditionalButton("C35", 50, 108, 35, 35, () -> DataCache.penSize == Constants.mediumPen, () -> {
            DataCache.penSize = Constants.mediumPen;
        });

        C36 = new ConditionalButton("C36", 85, 108, 35, 35, () -> DataCache.penSize == Constants.smallPen, () -> {
            DataCache.penSize = Constants.smallPen;
        });

        C44 = new ConditionalButton("C03", 100, 100, 50, 50, () -> (true), () -> { //TODO add condition
            Game.setScreen(S09);
        });

        C45 = new ConditionalButton("C03", 100, 100, 50, 50, () -> (true), () -> { //TODO add condition
            Game.setScreen(S10);
        });
        
        C46 = new ConditionalButton("C03", 100, 100, 50, 50, () -> (true), () -> { //TODO add condition
            Game.setScreen(S11);
        });

        C47 = new ConditionalButton("C03", 100, 100, 50, 50, () -> (true), () -> { //TODO add condition
            Game.setScreen(S12);
        });

        C48 = new ConditionalButton("C48", 642, 67, 50, 50, () -> !DataCache.myShip.retrieveData().hasAllDrawings(), () -> {
            for(Drawing d: DataCache.myShip.retrieveData().ShipSketches){
                d.constructImage();
            }
            Game.setScreen(S09);
        });

        

        I01 = new TextInput(298, 293, 24, 50, Color.WHITE,false,73, true, "Input Ship Name");
        I02 = new TextInput(400, 60, 24, 30, Color.BLACK, false, 73, false, "Title");
        I03 = new TextInput(400, 100, 15, 23, Color.BLACK, true, 32, false, "Type here...");


        S01 = new Screen("S01");
            Button[] BS01 = {B01, B02, B10, B21, C07};
            S01.addButtons(BS01);
            S01.overrideImage("S01.gif");
    
        S02 = new Screen("S02");
            Button[] BS02 = {B01, B03, B04, B10, I01};
            S02.addButtons(BS02);
    
        S03 = new Screen("S03");
            Button[] BS03 = {B01, B05, B06, B07, B09, B10};
            S03.addButtons(BS03);
    
        S04 = new Screen("S04");
            Button[] BS04 = {B01, B08, B09, B10};
            S04.addButtons(BS04);
            S04.excludeFromHistory();
    
        S05 = new Screen("S05");
            Button[] BS05 = {B01, B08, B09, B10};
            S05.addButtons(BS05);
            S05.excludeFromHistory();

        S06 = new Screen("S06");
            Button[] BS06 = {B01, B08, B09, B10};
            S06.addButtons(BS06);
            S06.excludeFromHistory();
    
        S07 = new Screen("S07"); //Notebook entry
            Button[] BS07 = {B01, B09, B19, B22, B23, C03, C04, I02, I03};
            S07.addButtons(BS07);
            S07.excludeFromHistory();

        S08 = new Screen("S08"); //Drawing
            Button[] BS08 = {B01, B09, B12, C05, C06, C14, C15, C16, C17, C18, C19, C20, C21, C22, C23, C24, C25, C26, C27, C28, C31, C32, C33, C34, C35, C36, C48};
            S08.addButtons(BS08);
            S08.addScript(() -> {
                DataCache.drawingEnabled = true;
                DataCache.myShip.retrieveData().ShipSketches[DataCache.componentIndex].savePoints(DataCache.drawing);
                DataCache.myShip.retrieveData().ShipSketches[DataCache.componentIndex].draw();
                Game.Graphics().setColor(Color.BLACK);
                Game.Graphics().drawString(DataCache.myShip.retrieveData().ShipRequirements[DataCache.componentIndex], 326, 75);
            });
    
        S09 = new Screen("S09");
            Button[] BS09 = {B01, B09, B12, C45};
            S09.addButtons(BS09);
            S09.addScript(() -> {
                int x = 0;
                for(Drawing d: DataCache.myShip.retrieveData().ShipSketches){
                    Game.Graphics().drawImage(d.asPicture(), x, 100, d.width(), d.height(), null);
                    x += 50;
                }
            });
    
        S10 = new Screen("S10");
            Button[] BS10 = {B01, B09, B12, C46};
            S10.addButtons(BS10);
    
        S11 = new Screen("S11");
            Button[] BS11 = {B01, B09, B12, C47};
            S11.addButtons(BS11);
    
        S12 = new Screen("S12");
            Button[] BS12 = {B01, B09, B11};
            S12.addButtons(BS12);
    
        S13 = new Screen("S13");
            Button[] BS13 = {B01};
    
        S14 = new Screen("S14");
            Button[] BS14 = {B01, B20};
            S14.addButtons(BS14);
    
        S15 = new Screen("S15");
            Button[] BS15 = {B01, B09};
            S15.addButtons(BS15);
            S15.excludeFromHistory();
    
        S16 = new Screen("S16");
        Button[] BS16 = {B01};
    
        S17 = new Screen("S17");
        Button[] BS17 = {B01};
    
        S18 = new Screen("S18");
        Button[] BS18 = {B01};
    
        S19 = new Screen("S19");
            Button[] BS19 = {B01};
    
        S20 = new Screen("S20");
        Button[] BS20 = {B01};

        black = new Color(0, 0, 0);
        white = new Color(255, 255, 255);
        yellow = new Color(235, 212, 91);
        lightBlue = new Color(159, 215, 225);
        red = new Color(182, 78, 78);
        turquoise = new Color(59, 144, 171);
        purple = new Color(122, 48, 116);
        hotPink = new Color (200, 0, 168);
        orange = new Color(219, 143, 81);
        darkPurple = new Color(73, 49, 118);
        lightGreen = new Color(160, 223, 134);
        lightPink = new Color(214, 162, 219);
        skyBlue = new Color(187, 208, 255);
        green = new Color(98, 139, 98);
        burgundy = new Color(130, 19, 19);
        blue = new Color(83, 94, 150);
        pink = new Color(235, 176, 218);

        DataCache.penColor = black;
    }
}
