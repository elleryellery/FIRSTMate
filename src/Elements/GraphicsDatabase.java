package Elements;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.swing.ImageIcon;

import Structure.*;

public abstract class GraphicsDatabase {
    public static Button B01, B02, B03, B04, B05, B06, B07, B08, B09, B10, B11, B12, B13, B14, B15, B16, B17, B18, B19, B20, B21, B22, B23, B24, B25, B26, B27, B28, B29, B30;

    public static TextInput I01, I02, I03, I04;

    public static ConditionalButton C01, C02, C03, C04, C05, C06, C07, C08, C09, C10, C11, C12, C13, C14, C15, C16, C17, C18, C19, C20, C21, C22, C23, C24, C25, C26, C27, C28, C29, C30, C31, C32, C33, C34, C35, C36, C44, C45, C46, C47, C48, C49, C50, C51, C52, C53;

    public static Screen S01, S02, S03, S04, S05, S06, S07, S08, S09, S10, S11, S12, S13, S14, S15, S16, S17, S18, S19, S20, S21;

    public static Draggable D05;

    public static Color black, white, yellow, lightBlue, red, turquoise, purple, hotPink, orange, darkPurple, lightGreen, lightPink, skyBlue, green, burgundy, blue, pink;

    public static Sound ballerina, seagulls, emeraldseas, lazylaura;

    public static Credit seagullImage, pirateShipImage, seagullSound, emeraldseasMusic, buttonSound, lazyLauraMusic, ballerinaMusic, canva, people;

    public static void init(){

        seagullImage =new Credit("Image","Seagull","pngimg.com: https://pngimg.com/image/5403","No Attribution Required");
        pirateShipImage = new Credit("Image","Pirate Ship","Vecteezy: https://www.vecteezy.com/png/21515322-seagull-flying-on-transparent-background-png-file","Attribution-NonCommercial 4.0 International (CC BY-NC 4.0)");
        seagullSound = new Credit("Sound","Seagull Sounds","'sg03' by Pixabay on Pixabay: https://pixabay.com/sound-effects/sg03-55932/","No Attribution Required");
        emeraldseasMusic = new Credit("Music","Title Screen Background Music","'Emerald Seas' by Aaron Kenny on YouTube Studio Audio Library: https://www.youtube.com/channel/UCVAggfwI4hnkA2WO6-xC06Q","YouTube Audio Library License (No Attribution Required)");
        buttonSound = new Credit("Sound","Button Sound Effect","'Multi Pop 1' by floraphonic on Pixabay: https://pixabay.com/sound-effects/multi-pop-1-188165/","No Attribution Required");
        lazyLauraMusic = new Credit("Music","Background Music ('Ballerina')","'Ballerina' by Quincas Moreira on YouTube Studio Audio Library: https://www.youtube.com/@QuincasMoreira","YouTube Audio Library License (No Attribution Required)");
        ballerinaMusic = new Credit("Music","Background Music ('Lazy Laura')","'Lazy Laura' by Quincas Moreira on YouTube Studio Audio Library: https://www.youtube.com/@QuincasMoreira","YouTube Audio Library License (No Attribution Required)");
        canva = new Credit("Image","Canva","Graphics designed using Canva: https://www.canva.com/","Canva Pro Content license (No Attribution Required)");
        people = new Credit("People","Developers & Contributors","FIRSTMate was developed by Ellery McDaniel from FRC 9181 PlatyPirates. Thank you to the members of the PlatyPirates for their help!","N/A");

        String [] patches1_0 = {"None"};
        String [] features1_0 = {"Title screen", "Credits", "In-game release notes", "Sound"};

        Release[] releases = {
            new Release("1.0","February 30, 2024", "Created game foundations", patches1_0, features1_0),
        };

        B01 = new Button("B01", 1130, 0, 50, 50, () -> {Game.setScreen(S16);}); //Settings
        B02 = new Button("B02", 470, 400, 250, 78, () -> {Game.setScreen(S02);}); //New Design
        B03 = new Button("B03", 0, 0, 50, 50, () -> {Game.setScreen(S01);}); //Home TODO Save progress
        B04 = new Button("B04", 470, 400, 250, 78, () -> { //Create ship
            Game.setScreen(S03);
            DataCache.myShip = new Ship(I01.contents());
        });
        B07 = new Button("B07", 170, 200, 235, 281, () -> { //Cruiser
            String[] components = {         
                "Restaurant", "Movie Theater", "Party Room", "Fun Area 1", "Fun Area 2"
            };
            DataCache.myShip.retrieveData().setShipRequirements(components);
            DataCache.myShip.retrieveData().ShipType = "Cruiser";
            Game.setScreen(S04);
        });
        B06 = new Button("B06", 470, 200, 235, 281, () -> { //Pearl
            String[] components = {            
                "Cannons", "A way to board other ships", "Treasure Room", "Fighting mechanism"
            };
            DataCache.myShip.retrieveData().setShipRequirements(components);
            DataCache.myShip.retrieveData().setShipRequirements(components);
            DataCache.myShip.retrieveData().ShipType = "The Pearl";
            Game.setScreen(S06);
        });
        B05 = new Button("B05", 770, 200, 235, 281, () -> { //Ghoul
            String[] components = {            
                "Trap #1", "Trap #2", "Protective Layer", "Scary Flag"
            };
            DataCache.myShip.retrieveData().setShipRequirements(components);
            DataCache.myShip.retrieveData().ShipType = "The Ghoul";
            Game.setScreen(S05);
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
            DataCache.myShip.retrieveData().Notebook.replaceEntry(1, entry);
            ScreenScripts.PullNotebookPageToTextBox();
            Game.setScreen(S07);
            ScreenScripts.PullNotebookPageToTextBox();
            ScreenScripts.PullNotebookPageToTextBox();
        });
        B09 = new Button("B09", 0, 0, 50, 50, () -> {Game.previousScreen();}); //Back/Previous
        
        B10 = new Button("B10", 0, 561, 50, 50, () -> {//TODO Check ship and provide relevant animation
            Game.setScreen(S17);
        });

        B11 = new Button("B11", 920, 523, 250, 78, () -> {
            String status = "passed";
            int sailWeight = DataCache.myShip.retrieveData().sailWeight();
            if(sailWeight > 900){
            } else {
                status = "Whoops! Your sail is too light, so it can't catch the wind and sail on the seas. Make your sail a little larger and try again!";
            }
            
            if(!DataCache.myShip.sinks()){
            } else {
                status = "Oh no! Your ship is too heavy, and it sank! Try to cut some weight from your ship, and try again!";
            }
            
            if(DataCache.myShip.retrieveData().checkStability() < 5){
            } else {
                status = "Arggh! Your ship collapsed due to instability! Try to eliminate weak points on your ship by making sure that nothing is floating or too skinny.";
            }

            if(status.equals("passed")){
                Game.setScreen(S14);
            } else {
                DataCache.failureMessage = status;
                Game.setScreen(S13);
            }
        });

        B12 = new Button("B12", 1097, 526, 80, 80, () -> {
            Game.setScreen(S15);
        });

        B19 = new Button("B20", 719, 533, 50, 50, () -> { //TODO Save notebook entry
            DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber).update();
            Game.setScreen(S08);
            if(DataCache.myShip.retrieveData().ShipSketches.length > 0){
                DataCache.drawing = DataCache.myShip.retrieveData().ShipSketches[0].getPoints();
            }
        });

        B20 = new Button("B20", 493, 532, 250, 78, () -> { //TODO Save notebook entry
            DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber).update();
            Game.setScreen(S01);
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

        B24 = new Button("B08", 450, 521, 250, 78, () -> {
            DataCache.myShip = DataCache.ships.get(DataCache.shipIndex);
            if(DataCache.myShip.retrieveData().hasAllDrawings()){
                Button[] BS09 = {B01, B09, B12, C47};
                Button[] temp = Stream.concat(Arrays.stream(BS09), Arrays.stream(ScreenScripts.convertSketchesToDraggables())).toArray(Button[]::new);
                S09.addButtons(temp);
                ScreenScripts.PullNotebookPageToTextBox();
                Game.setScreen(S07);
            } else {
                ScreenScripts.PullNotebookPageToTextBox();
                Game.setScreen(S07);
            }
        });

        B25 = new Button("B25", 450, 0, 75, 75, () -> {
            if(DataCache.waterLevel < 15){
                DataCache.waterLevel ++;
                if(DataCache.waterLevel > 3 && !DataCache.myShip.sinks()){
                    DataCache.shipLevel += 20;
                }
            }
        });
        B26 = new Button("B26", 550, 0, 75, 75, () -> {
            DataCache.enabledCannons = !DataCache.enabledCannons;
        });

        B27 = new Button("B27", 650, 0, 75, 75, () -> {
            DataCache.winds.add(new Wind());
        });

        B28 = new Button("B11", 478, 474, 250, 78, () -> {
            Game.setScreen(S08);
        });

        B29 = new Button("B29", 1090, 8, 35, 35, () -> {
            DataCache.shipLevel = 0;
            DataCache.waterLevel = 0;
            DataCache.winds.clear();
            DataCache.cannonball = null;
            DataCache.shipTestPos = -150;
        });

        B30 = new Button("B30", 120, 280, 50, 50, () -> {
            Game.setScreen(S21);
        });

        C01 = new ConditionalButton("C01", 800, 400, 200, 100, () -> (Settings.enabledMusic), () -> {
            Settings.enabledMusic = !Settings.enabledMusic;
            Screen.sfx.stopAllSounds();
            if(Settings.enabledMusic){
                DataCache.myScreen.setStartPlayer(true);
            }
        });

        C02 = new ConditionalButton("C02", 800, 200, 200, 100, () -> (Settings.enabledSoundEffects), () -> {
            Settings.enabledSoundEffects = !Settings.enabledSoundEffects;
            Screen.sfx.stopAllSounds();
        });

        C04 = new ConditionalButton("C04", 395, 535, 50, 50, () -> !(DataCache.pageNumber > 0), () -> { //Back
            if(DataCache.pageNumber > 0){
                DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber).update();
                DataCache.pageNumber --;
                ScreenScripts.PullNotebookPageToTextBox();
            }
        });

        C03 = new ConditionalButton("C03", 664, 535, 50, 50, () -> !(DataCache.myShip == null ||( DataCache.pageNumber < DataCache.myShip.retrieveData().Notebook().entries().size() -1 )), () -> {
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
        });
        
        C06 = new ConditionalButton("C06", 519, 70, 50, 50, () -> !(DataCache.componentIndex > 0), () -> { //Previous component
            if(DataCache.componentIndex > 0){
                DataCache.componentIndex --;
                DataCache.drawing = DataCache.myShip.retrieveData().ShipSketches[DataCache.componentIndex].getPoints();
            }
        });

        C07 = new ConditionalButton("C07", 470, 125, 250, 78, () -> (!(DataCache.ships.size() > 0)), () -> { 
            Game.setScreen(S19);
        });

        C08 = new ConditionalButton("C09", 118, 445, 50, 50, () -> !(DataCache.myScreen != null && DataCache.creditIndex > 0), () -> { //Previous credit
            if(DataCache.creditIndex > 0){
                DataCache.creditIndex --;
            }
        });

        C09 = new ConditionalButton("C08", 1041, 445, 50, 50, () -> (!(DataCache.myScreen != null && DataCache.creditIndex < DataCache.history.getLast().credits().length - 1)), () -> { //Next credit
            if(DataCache.creditIndex < DataCache.history.getLast().credits().length - 1){
                DataCache.creditIndex ++;
            }
        });

        C10 = new ConditionalButton("C11", 118, 475, 50, 50, () -> !(DataCache.releaseIndex > 0), () -> { //Previous credit
            if(DataCache.releaseIndex > 0){
                DataCache.releaseIndex --;
            }
        });

        C11 = new ConditionalButton("C10", 1041, 475, 50, 50, () -> (!(DataCache.releaseIndex < releases.length - 1)), () -> { //Next credit
            if(DataCache.releaseIndex < releases.length - 1){
                DataCache.releaseIndex ++;
            }
        });

        C12 = new ConditionalButton("C12", 672, 294, 50, 50, () -> !(Settings.volume < 100), () -> {
            if(Settings.volume < 100){
                Settings.volume += 5;
            }
        });

        C13 = new ConditionalButton("C13", 307, 294, 50, 50, () -> !(Settings.volume > 0), () -> {
            if(Settings.volume > 0){
                Settings.volume -= 5;
            }
        });

        C14 = new ConditionalButton("C14", 15, 150, 75, 75, () -> (DataCache.penColor == black), () -> {
            DataCache.penColor = black;
            if(DataCache.penType == "Erase"){
                DataCache.penType = "Scribble";
            }
        });

        C15 = new ConditionalButton("C15", 90, 150, 75, 75, () -> (DataCache.penColor == white), () -> {
            DataCache.penColor = white;
            if(DataCache.penType == "Erase"){
                DataCache.penType = "Scribble";
            }
        });

        C16 = new ConditionalButton("C16", 165, 150, 75, 75, () -> (DataCache.penColor == yellow), () -> {
            DataCache.penColor = yellow;
            if(DataCache.penType == "Erase"){
                DataCache.penType = "Scribble";
            }
        });

        C17 = new ConditionalButton("C17", 15, 225, 75, 75, () -> (DataCache.penColor == lightBlue), () -> {
            DataCache.penColor = lightBlue;
            if(DataCache.penType == "Erase"){
                DataCache.penType = "Scribble";
            }
        });

        C18 = new ConditionalButton("C18", 90, 225, 75, 75, () -> (DataCache.penColor == red), () -> {
            DataCache.penColor = red;
            if(DataCache.penType == "Erase"){
                DataCache.penType = "Scribble";
            }
        });

        C19 = new ConditionalButton("C19", 165, 225, 75, 75, () -> (DataCache.penColor == turquoise), () -> {
            DataCache.penColor = turquoise;
            if(DataCache.penType == "Erase"){
                DataCache.penType = "Scribble";
            }
        });

        C20 = new ConditionalButton("C20", 15, 300, 75, 75, () -> (DataCache.penColor == purple), () -> {
            DataCache.penColor = purple;
            if(DataCache.penType == "Erase"){
                DataCache.penType = "Scribble";
            }
        });

        C21 = new ConditionalButton("C21", 90, 300, 75, 75, () -> (DataCache.penColor == hotPink), () -> {
            DataCache.penColor = hotPink;
            if(DataCache.penType == "Erase"){
                DataCache.penType = "Scribble";
            }
        });

        C22 = new ConditionalButton("C22", 165, 300, 75, 75, () -> (DataCache.penColor == orange), () -> {
            DataCache.penColor = orange;
            if(DataCache.penType == "Erase"){
                DataCache.penType = "Scribble";
            }
        });

        C23 = new ConditionalButton("C23", 15, 375, 75, 75, () -> (DataCache.penColor == darkPurple), () -> {
            DataCache.penColor = darkPurple;
            if(DataCache.penType == "Erase"){
                DataCache.penType = "Scribble";
            }
        });

        C24 = new ConditionalButton("C24", 90, 375, 75, 75, () -> (DataCache.penColor == lightGreen), () -> {
            DataCache.penColor = lightGreen;
            if(DataCache.penType == "Erase"){
                DataCache.penType = "Scribble";
            }
        });

        C25 = new ConditionalButton("C25", 165, 375, 75, 75, () -> (DataCache.penColor == lightPink), () -> {
            DataCache.penColor = lightPink;
            if(DataCache.penType == "Erase"){
                DataCache.penType = "Scribble";
            }
        });

        C26 = new ConditionalButton("C26", 15, 450, 75, 75, () -> (DataCache.penColor == skyBlue), () -> {
            DataCache.penColor = skyBlue;
            if(DataCache.penType == "Erase"){
                DataCache.penType = "Scribble";
            }
        });

        C27 = new ConditionalButton("C27", 90, 450, 75, 75, () -> (DataCache.penColor == green), () -> {
            DataCache.penColor = green;
            if(DataCache.penType == "Erase"){
                DataCache.penType = "Scribble";
            }
        });

        C28 = new ConditionalButton("C28", 165, 450, 75, 75, () -> (DataCache.penColor == burgundy), () -> {
            DataCache.penColor = burgundy;
            if(DataCache.penType == "Erase"){
                DataCache.penType = "Scribble";
            }
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

        C44 = new ConditionalButton("C48", 100, 100, 50, 50, () -> (false), () -> { //TODO add condition
            Game.setScreen(S09);
        });

        C45 = new ConditionalButton("C48", 100, 100, 50, 50, () -> (false), () -> { //TODO add condition
            Game.setScreen(S10);
        });
        
        C46 = new ConditionalButton("C48", 100, 100, 50, 50, () -> (false), () -> { //TODO add condition
            Game.setScreen(S11);
        });

        C47 = new ConditionalButton("C48", 709, 8, 50, 50, () -> (false), () -> {
            for(Drawing d: DataCache.myShip.retrieveData().ShipSketches){
                d.saveCoords();
            }
            Game.setScreen(S12);
            DataCache.winds.clear();
            DataCache.waterLevel = 0;
            DataCache.shipLevel = 0;
            DataCache.shipTestPos = -150;
        });

        C48 = new ConditionalButton("C48", 642, 67, 50, 50, () -> !DataCache.myShip.retrieveData().hasAllDrawings(), () -> {
            if(DataCache.myShip.retrieveData().hasAllDrawings()){
                for(Drawing d: DataCache.myShip.retrieveData().ShipSketches){
                    d.constructImage();
                }
                Button[] BS09 = {B01, B09, B12, C47};
                Button[] temp = Stream.concat(Arrays.stream(BS09), Arrays.stream(ScreenScripts.convertSketchesToDraggables())).toArray(Button[]::new);
                S09.addButtons(temp);
                Game.setScreen(S09);
            }
        });
        C49 = new ConditionalButton("C05", 1028, 270, 50, 50, () -> !(DataCache.shipIndex < DataCache.ships.size() - 1), () -> { //Next component
            if(DataCache.shipIndex < DataCache.ships.size() - 1){
                DataCache.shipIndex ++;
            }
        });
        
        C50 = new ConditionalButton("C06", 116, 270, 50, 50, () -> !(DataCache.shipIndex > 0), () -> { //Previous component
            if(DataCache.shipIndex > 0){
                DataCache.shipIndex --;
            }
        });

        C51 = new ConditionalButton("C01", 15, 10, 100, 50, () -> (Settings.tutorialModeEnabled), () -> { //Previous component
            Settings.tutorialModeEnabled = !Settings.tutorialModeEnabled;
        });

        C52 = new ConditionalButton("C04", 200, 500, 50, 50, () -> !(DataCache.pageNumber > 0), () -> { //Back
            if(DataCache.pageNumber > 1){
                DataCache.pageNumber -= 2;
            }
        });

        C53 = new ConditionalButton("C03", 940, 500, 50, 50, () -> !(DataCache.myShip == null || (DataCache.pageNumber < DataCache.myShip.retrieveData().Notebook().entries().size() -2)), () -> {
            if(DataCache.pageNumber < DataCache.myShip.retrieveData().Notebook().entries().size() -2){
                DataCache.pageNumber += 2;
            }
        });

        I01 = new TextInput(298, 293, 24, 50, Color.WHITE,false,73, true, "Type here...");
        I02 = new TextInput(400, 60, 24, 30, Color.BLACK, false, 73, false, "Type here...");
        I03 = new TextInput(400, 100, 15, 23, Color.BLACK, true, 32, false, "Type here...");

        D05 = new Draggable("D05", 40, 258, 100, 100);

        seagulls = new Sound("Seagulls", 'M', true, 95);
        emeraldseas = new Sound("EmeraldSeas", 'M', true, 85);
        ballerina = new Sound("Ballerina", 'M', true, 75);
        lazylaura = new Sound("LazyLaura", 'M', true, 75);

        S01 = new Screen("S01"); //Starting/Opening Screen
            Button[] buttons01 = {B01, B02, B10, B21, C07, C51};
            Sound[] sounds01 = {seagulls, emeraldseas};
            Credit[] credits01 = {seagullImage, pirateShipImage, seagullSound, emeraldseasMusic, buttonSound, canva};
            S01.addButtons(buttons01);
            S01.overrideImage("S01.gif");
            S01.addScript(() -> {
                Game.Graphics().setColor(Color.WHITE);
                Game.Graphics().drawString("Tutorial Mode", 7, 80);
            });
            S01.addBackgroundSounds(sounds01);
            S01.addCredits(credits01);
    
        S02 = new Screen("S02"); //Name your design
            Button[] BS02 = {B01, B03, B04, B10, I01};
            Sound[] sounds02 = {ballerina};
            Credit[] credits02 = {ballerinaMusic, buttonSound, canva};
            S02.addButtons(BS02);
            S02.addBackgroundSounds(sounds02);
            S02.addCredits(credits02);
    
        S03 = new Screen("S03"); //Choose ship type
            Button[] BS03 = {B01, B05, B06, B07, B09, B10};
            Sound[] sounds03 = {ballerina};
            Credit[] credits03 = {ballerinaMusic, buttonSound, canva};
            S03.addButtons(BS03);
            S03.addBackgroundSounds(sounds03);
            S03.addCredits(credits03);
                
        S04 = new Screen("S04"); //Cruiser
            Button[] BS04 = {B01, B08, B09, B10};
            Sound[] sounds04 = {ballerina};
            Credit[] credits04 = {ballerinaMusic, buttonSound, canva};
            S04.addButtons(BS04);
            S04.excludeFromHistory();
            S04.addBackgroundSounds(sounds04);
            S04.addCredits(credits04);
    
        S05 = new Screen("S05"); //The Ghoul
            Button[] BS05 = {B01, B08, B09, B10};
            Sound[] sounds05 = {ballerina};
            Credit[] credits05 = {ballerinaMusic, buttonSound, canva};
            S05.addButtons(BS05);
            S05.excludeFromHistory();
            S05.addBackgroundSounds(sounds05);
            S05.addCredits(credits05);

        S06 = new Screen("S06"); //The Pearl
            Button[] BS06 = {B01, B08, B09, B10};
            Sound[] sounds06 = {ballerina};
            Credit[] credits06 = {ballerinaMusic, buttonSound, canva};
            S06.addButtons(BS06);
            S06.excludeFromHistory();
            S06.addBackgroundSounds(sounds06);
            S06.addCredits(credits06);
    
        S07 = new Screen("S07"); //Notebook entry
            Button[] BS07 = {B01, B09, B19, B22, B23, C03, C04, I02, I03};
            Sound[] sounds07 = {lazylaura};
            Credit[] credits07 = {lazyLauraMusic, buttonSound, canva};
            S07.addButtons(BS07);
            S07.excludeFromHistory();
            S07.addBackgroundSounds(sounds07);
            S07.addCredits(credits07);
        
        S21 = new Screen("S07"); //Notebook entry
            Button[] BS21 = {B01, B09, B19, B22, B23, C03, C04, I02, I03};
            Sound[] sounds21 = {lazylaura};
            Credit[] credits21 = {lazyLauraMusic, buttonSound, canva};
            S21.addButtons(BS21);
            S21.excludeFromHistory();
            S21.addBackgroundSounds(sounds21);
            S21.addCredits(credits21);

        S08 = new Screen("S08"); //Drawing
            Button[] BS08 = {B01, B09, B12, C05, C06, C14, C15, C16, C17, C18, C19, C20, C21, C22, C23, C24, C25, C26, C27, C28, C31, C32, C33, C34, C35, C36, C48};
            Sound[] sounds08 = {lazylaura};
            Credit[] credits08 = {lazyLauraMusic, buttonSound, canva};
            S08.addButtons(BS08);
            S08.addScript(() -> {
                DataCache.drawingEnabled = true;
                DataCache.myShip.retrieveData().ShipSketches[DataCache.componentIndex].draw();
                if(DataCache.lineStart != null && DataCache.lineEnd != null){
                    Game.Graphics().setColor(DataCache.penColor);
                    ((Graphics2D) Game.Graphics()).setStroke(new BasicStroke(DataCache.penSize));
                    Game.Graphics().drawLine(DataCache.lineStart.x(), DataCache.lineStart.y(), DataCache.lineEnd.x(), DataCache.lineEnd.y());
                }
                Game.Graphics().setColor(Color.BLACK);
                Game.Graphics().drawString(DataCache.myShip.retrieveData().ShipRequirements[DataCache.componentIndex], 326, 75);
            });
            S08.addBackgroundSounds(sounds08);
            S08.addCredits(credits08);
    
        S09 = new Screen("S10"); //Composition
            Button[] BS09 = {B01, B09, B12, C47};
            Sound[] sounds09 = {lazylaura};
            Credit[] credits09 = {lazyLauraMusic, buttonSound, canva};
            S09.addButtons(BS09);
            S09.addBackgroundSounds(sounds09);
            S09.addCredits(credits09);
            // S09.addScript(() -> {
            //     int x = 0;
            //     for(Drawing d: DataCache.myShip.retrieveData().ShipSketches){
            //         Game.Graphics().drawImage(d.asPicture(), x, 100, d.width(), d.height(), null);
            //         x += 50;
            //     }
            // });
    
        S12 = new Screen("S12"); //Testing
            Button[] BS12 = {B01, B09, B11, B25, B26, B27, B29};
            Sound[] sounds12 = {seagulls, lazylaura};
            Credit[] credits12 = {seagullSound, lazyLauraMusic, buttonSound, canva};
            S12.addButtons(BS12);
            S12.addBackgroundSounds(sounds12);
            S12.addCredits(credits12);
            S12.addScript(() -> {
                Game.Graphics().drawImage(new ImageIcon("FIRSTMate-Assets\\M\\Water.png").getImage(), 0, 610 - DataCache.waterLevel * 20, 1200, 310, null);
                int windSpeed = 0;
                for(Wind w: DataCache.winds){
                    w.drawWind();
                    windSpeed ++;
                }
                int sailWeight = DataCache.myShip.retrieveData().sailWeight();
                int shipMovement = 0;
                if(sailWeight > 900){
                    shipMovement = windSpeed;
                } else if(windSpeed > 1){
                    DataCache.failureMessage = "Whoops! Your sail is too light, so it can't catch the wind and sail on the seas. Make your sail a little larger and try again!";
                    Game.setScreen(S13);
                }

                DataCache.shipTestPos += shipMovement;

                int x = DataCache.shipTestPos;
                if(x > 1200-150){
                    DataCache.shipTestPos = -1200;
                }
                int y = -DataCache.shipLevel;

                if(DataCache.enabledCannons){
                   // Button[] temp = Stream.concat(Arrays.stream(BS12), Arrays.stream(d5)).toArray();
                    Button[] temp = new Button[BS12.length + 1];
                    for(int i = 0; i < temp.length - 1; i ++){
                        temp[i] = BS12[i];
                    }
                    temp[temp.length - 1] = D05;
                    S12.addButtons(temp);
                    Game.Graphics().setColor(Color.BLACK);
                    Game.Graphics().drawLine(0, 308, D05.x() +25, D05.y() + (int)(D05.h()/2));

                    if(DataCache.cannonball != null){
                        DataCache.myShip.retrieveData().drawShipCopy(x, y);
                        DataCache.cannonball.drawCannonball(x, y);
                        if(DataCache.cannonball.x() > 1200 || DataCache.cannonball.y() > 650){
                            DataCache.cannonball = null;
                            int weakPoint = DataCache.myShip.retrieveData().checkDestruction();
                            if(weakPoint > 0) {
                                DataCache.failureMessage = "Oh no! The cannonballs exposed a weak spot in your ship's design. Strengthen your ship by adding onto it until the cannonball can not easily pass through.";
                                Game.setScreen(S13);
                            }
                        }
                    } else {
                        DataCache.myShip.retrieveData().drawShipWithRotatingWheel(x, y);
                    }
                } else {
                    DataCache.myShip.retrieveData().drawShipWithRotatingWheel(x, y);
                    S12.addButtons(BS12);
                }


                
            });
    
        S13 = new Screen("S13"); //Failure note
            Button[] BS13 = {B01, B28};
            Credit[] credits13 = {canva};
            S13.addButtons(BS13);
            S13.addScript(() -> {
                TextInterpreter t = new TextInterpreter();
                Game.Graphics().setColor(Color.WHITE);
                t.drawText(Game.Graphics(), DataCache.failureMessage, 382, 310, 50);
            });
            S13.addCredits(credits13);
    
        S14 = new Screen("S14"); //Completion screen
            Button[] BS14 = {B01, B03};
            Credit[] credits14 = {canva, people};
            S14.addButtons(BS14);
            S14.addCredits(credits14);
    
        S15 = new Screen("S15"); //View notebook
            Button[] BS15 = {B01, B09, B30, C52, C53};
            Sound[] sounds15 = {ballerina};
            Credit[] credits15 = {ballerinaMusic, buttonSound, canva};
            S15.addButtons(BS15);
            S15.addBackgroundSounds(sounds15);
            TextInterpreter text = new TextInterpreter();
            S15.addCredits(credits15);
            S15.addScript(() -> {
                Game.Graphics().setColor(Color.BLACK);

                Game.Graphics().setFont( new Font("Times New Roman", Font.ITALIC, 15));

                text.drawText(Game.Graphics(), DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber).metadata(), 220, 80, 30);

                Game.Graphics().setFont( new Font("Times New Roman", Font.BOLD, 30));
                text.drawText(Game.Graphics(), DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber).name(), 220, 115, 30);

                Game.Graphics().setFont( new Font("Times New Roman", Font.PLAIN, 23));
                text.drawText(Game.Graphics(), DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber).entry(), 220, 150, 30);

                if(DataCache.pageNumber < DataCache.myShip.myNotebook().entries().size() -1 ){
                    Game.Graphics().setFont( new Font("Times New Roman", Font.ITALIC, 15));

                    text.drawText(Game.Graphics(), DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber + 1).metadata(), 640, 80, 30);
    
                    Game.Graphics().setFont( new Font("Times New Roman", Font.BOLD, 30));
                    text.drawText(Game.Graphics(), DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber + 1).name(), 640, 115, 30);
    
                    Game.Graphics().setFont( new Font("Times New Roman", Font.PLAIN, 23));
                    text.drawText(Game.Graphics(), DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber + 1).entry(), 640, 150, 30);
    
                }
            });
            S15.excludeFromHistory();
    
        S16 = new Screen("S16"); //Settings
            Button[] BS16 = {B09, C01, C02, C12, C13};
            Sound[] sounds16 = {ballerina};
            Credit[] credits16 = {ballerinaMusic, buttonSound, canva};
            S16.addBackgroundSounds(sounds16);
            S16.addButtons(BS16);
            S16.excludeFromHistory();
            S16.addCredits(credits16);
            S16.addScript(() -> {
                Game.Graphics().setColor(Color.BLACK);
                Game.Graphics().setFont(new Font("Times New Roman", Font.BOLD, 150));
                Game.Graphics().drawString(Settings.volume + "", 400, 375);
            });
    
        S17 = new Screen("S17"); //Credits
            Button[] BS17 = {B01, B09, C08, C09};
            Sound[] sounds17 = {ballerina};
            S17.addButtons(BS17);
            S17.addBackgroundSounds(sounds17);
            S17.addScript(() -> {
                Game.Graphics().setColor(new Color(	89, 142, 244));
                Game.Graphics().fillRect(100,100,1000,400);

                Game.Graphics().setColor(Color.WHITE);
                Game.Graphics().setFont( new Font("Times New Roman", Font.PLAIN, 18));

                text.drawText(Game.Graphics(),"Type: " +  DataCache.history.getLast().credits()[DataCache.creditIndex].type(), 150, 150, 90);

                Game.Graphics().setFont( new Font("Times New Roman", Font.BOLD, 35));

                text.drawText(Game.Graphics(),"Item: " +  DataCache.history.getLast().credits()[DataCache.creditIndex].item(), 150, 200, 90);

                Game.Graphics().setFont( new Font("Times New Roman", Font.PLAIN, 22));

                text.drawText(Game.Graphics(),"Source: " +  DataCache.history.getLast().credits()[DataCache.creditIndex].source(), 150, 240, 90);

                Game.Graphics().setFont( new Font("Times New Roman", Font.ITALIC, 22));

                text.drawText(Game.Graphics(),"License: " +  DataCache.history.getLast().credits()[DataCache.creditIndex].license(), 150, 425, 90);

            });
            S17.excludeFromHistory();
    
        S18 = new Screen("S18"); //Release Notes
            Button[] BS18 = {B01, B09, C10, C11};
            Sound[] sounds18 = {ballerina};
            S18.addButtons(BS18);
            S18.addBackgroundSounds(sounds18);
            S18.excludeFromHistory();
            S18.addScript(() -> {
                Game.Graphics().setColor(Color.BLACK);
                Game.Graphics().fillRect(100,100,1000,450);
        
                Game.Graphics().setColor(Color.LIGHT_GRAY);
                Game.Graphics().setFont( new Font("Times New Roman", Font.PLAIN, 17));
                Game.Graphics().drawImage(releases[DataCache.releaseIndex].bannerImage().getImage(),110,110,980,100,null);
                Game.Graphics().drawString("Version Number: " + releases[DataCache.releaseIndex].versionNumber(),150,250);
                Game.Graphics().drawString("Release Date: " + releases[DataCache.releaseIndex].releaseDate(),150,270);
                Game.Graphics().drawString("Summary: " + releases[DataCache.releaseIndex].summary(),150,290);
                Game.Graphics().setColor(Color.WHITE);
                Game.Graphics().setFont( new Font("Times New Roman", Font.BOLD, 17));
                Game.Graphics().drawString("Features: ",150,310);
                Game.Graphics().drawString("Bug Fixes and Patches: ",620,310);
        
                Game.Graphics().drawString("For more detailed release notes, visit our Github page linked on our team website!",310,580);
        
                Game.Graphics().setFont( new Font("Times New Roman", Font.PLAIN, 17));
                Game.Graphics().setColor(Color.LIGHT_GRAY);
        
                int yPlacement = 330;
                for(String f: releases[DataCache.releaseIndex].features()){
                    Game.Graphics().drawString("     ‣    " + f,150,yPlacement);
                    yPlacement+=20;
                }
        
                yPlacement = 330;
                for(String p: releases[DataCache.releaseIndex].patches()){
                    Game.Graphics().drawString("     ‣    " + p,620,yPlacement);
                    yPlacement+=20;
                }
            });
    
        S19 = new Screen("S19"); //View Saved Designs
            Button[] BS19 = {B01, B09, B24, C49, C50};
            Sound[] sounds19 = {seagulls, emeraldseas};
            S19.addBackgroundSounds(sounds19);
            S19.addButtons(BS19);
            S19.addScript(() -> {
                Color c = new Color(0, 0, 0, 80);
                Game.Graphics().setColor(c);
                Game.Graphics().setFont(new Font("Times New Roman", Font.BOLD, 50));

                Game.Graphics().drawString(DataCache.ships.get(DataCache.shipIndex).name(), 23, 580);
                
                DataCache.ships.get(DataCache.shipIndex).retrieveData().drawShip(-150, 0);
                
            });

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
        
        DataCache.tutorials.add(new TutorialBox("Welcome to FIRST Mate! Today you are going to be building a pirate ship.", () -> (DataCache.myScreen == S01)));
        DataCache.tutorials.add(new TutorialBox("To create your first ship, press \"New Design\".", () -> (DataCache.myScreen == S01), 773, 389));
        DataCache.tutorials.add(new TutorialBox("Nicely done! Let's start by giving your ship a name. Once you're done, click \"Create Ship\".", () -> (DataCache.myScreen == S02)));
        DataCache.tutorials.add(new TutorialBox("It's time to pick which type of ship you'd like to build. Each ship has different requirements, so choose carefully! Click on a type to learn more.", () -> (DataCache.myScreen == S03)));
        DataCache.tutorials.add(new TutorialBox("Nice choice! Now it's time to think about what you'd like to put on your ship.", () -> (DataCache.myScreen == S07), 854, 406));
        DataCache.tutorials.add(new TutorialBox("Let's start by jotting down some of your ideas for your ship. This is your design notebook, where you can write down all of your ideas.", () -> (DataCache.myScreen == S07), 854, 406));
        DataCache.tutorials.add(new TutorialBox("Start by navigating to the last page of your notebook.", () -> (DataCache.myScreen == S07), 854, 406));
        DataCache.tutorials.add(new TutorialBox("Great! Now add a new page to your notebook.", () -> (DataCache.pageNumber == 1), 854, 406));
        DataCache.tutorials.add(new TutorialBox("Nicely done! Start writing about what ideas you have for your ship. Take as much time as you need, and add more pages if you run out of space!", () -> (DataCache.pageNumber == 2), 854, 406));
        DataCache.tutorials.add(new TutorialBox("Once you're done, click the checkmark in the bottom right corner.", () -> (DataCache.pageNumber == 2), 854, 406));
        DataCache.tutorials.add(new TutorialBox("Now that you have some ideas for your ship, let's make some drawings for your ship.", () -> (DataCache.myScreen == S08), 533, 392));
        DataCache.tutorials.add(new TutorialBox("^^ Up here is the name of the ship part that you are currently working on. Move between parts using the arrows.", () -> (DataCache.myScreen == S08), 350, 140));
        DataCache.tutorials.add(new TutorialBox("In the box on the left you can change the color of your pen. At the top of the box you can also change the pen size and change to an eraser.", () -> (DataCache.myScreen == S08), 533, 392));
        DataCache.tutorials.add(new TutorialBox("Make sure to create a drawing for each ship part! Once you're done, you'll be able to click the checkmark at the top.", () -> (DataCache.myScreen == S08), 533, 392));
        DataCache.tutorials.add(new TutorialBox("You can also look back at what you wrote in your notebook at any time using the button in the bottom right corner.", () -> (DataCache.myScreen == S08), 533, 392));
        DataCache.tutorials.add(new TutorialBox("Let's put it all together! All of the ship parts you just drew are on the clipboard on the left. Drag them onto the ocean to put together your ship.", () -> (DataCache.myScreen == S09), 583, 392));
        DataCache.tutorials.add(new TutorialBox("Once you're happy with how your ship looks, click on the checkmark at the top to continue.", () -> (DataCache.myScreen == S09), 583, 392));
        DataCache.tutorials.add(new TutorialBox("Your ship is looking great! It's time to test your ship on the open seas.", () -> (DataCache.myScreen == S12)));
        DataCache.tutorials.add(new TutorialBox("Let's start by adding water to see if your ship will float. Click on the water button at the top until water starts to fill the ocean.", () -> (DataCache.myScreen == S12)));
        DataCache.tutorials.add(new TutorialBox("Your ship floats! Now it's time to test your ship's strength by throwing cannonballs at it. Click on the cannon button and drag the arrow to shoot cannonballs.", () -> (DataCache.waterLevel >= 5 && DataCache.myScreen == S12)));
        DataCache.tutorials.add(new TutorialBox("Nice! Time for the final test -- can your ship catch the wind in its sails and sail along the seas? Click the wind button to add wind.", () -> (DataCache.numCannonballsReleased >= 3 && DataCache.myScreen == S12)));
        DataCache.tutorials.add(new TutorialBox("Fantastic! It's time to send your ship on its first voyage. Hopefully your tests didn't miss anything! Press \"I'm done!\"", () -> (DataCache.winds.size() >0 && DataCache.myScreen == S12)));
        
    }
}
