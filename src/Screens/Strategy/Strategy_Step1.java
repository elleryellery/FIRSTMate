//Select Ship Type
package Screens.Strategy;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import General.*;
import Screens.Screen;

public class Strategy_Step1 extends Screen{
    Button[] myButtons2 = new Button[] {};
    int choice;

    public Strategy_Step1(){
    super(6,"New Ship Screen",new ImageIcon("IMG-Screens/SCREEN-Strategy_Step1.png"));

        String[] cruiserComponents = {
            "Restaurant", "Movie Theater", "Party Room", "Fun Area 1", "Fun Area 2"
        };

        String[] pearlComponents = {
            "Cannons", "Ship Boarding", "Treasure Room", "Fighting Mechanism"
        };

        String[] ghoulComponents = {
            "Trap 1", "Trap 2", "Protective Layer", "Scary Flag"
        };

        Credit[] myCredits = {

        };

        Button[] myButtons = {
            new Button("Cruiser", new ImageIcon("IMG-Buttons/BUTTON-Cruiser.png"),new ImageIcon("IMG-Buttons/BUTTON-CruiserHover.png"),170, 200,235,281, () -> {
                this.setBack(new ImageIcon("IMG-Screens/SCREEN-Cruiser.png"));
                choice = 1;
                this.setButtons(myButtons2);
            }),
            new Button("The Pearl", new ImageIcon("IMG-Buttons/BUTTON-ThePearl.png"),new ImageIcon("IMG-Buttons/BUTTON-ThePearlHover.png"),470, 200,235,281, () -> {
                this.setBack(new ImageIcon("IMG-Screens/SCREEN-Pearl.png"));
                choice = 2;
                this.setButtons(myButtons2);
            }),
            new Button("The Ghoul", new ImageIcon("IMG-Buttons/BUTTON-TheGhoul.png"),new ImageIcon("IMG-Buttons/BUTTON-TheGhoulHover.png"),770, 200,235,281, () -> {
                this.setBack(new ImageIcon("IMG-Screens/SCREEN-Ghoul.png"));
                choice = 3;
                this.setButtons(myButtons2);
            })
        };

        myButtons2 = new Button[] {
            new Button("Back To Options", new ImageIcon("IMG-Buttons/BUTTON-Left.png"),new ImageIcon("IMG-Buttons/BUTTON-LeftHover.png"),0, 5,50,50, () -> {
                this.setBack(new ImageIcon("IMG-Screens/SCREEN-Strategy_Step1.png"));
                this.setButtons(myButtons);
            }),
            new Button("Select Option", new ImageIcon("IMG-Buttons/BUTTON-IChooseThis.png"),new ImageIcon("IMG-Buttons/BUTTON-IChooseThisHover.png"),721, 428,250,78, () -> {
                switch(choice){
                    case 1:
                        Game.ship().myNotebook().fields().add(new Field("Your New Cruiser", 
                        "The cruiser is made for pirate fun!" + "`" +
                        "As a cruiser, your ship will be designed to give pirate riders a great time. Your cruiser must include:" + "`" +
                        "Your cruiser must include:" + "`" +
                        "  ‣   A restaurant" + "`" +
                        "  ‣   A movie theater" + "`" +
                        "  ‣   A party room" + "`" +
                        "  ‣   At least two other fun areas of your choosing!"));
                        Game.setComponents(cruiserComponents);
                        
                        break;
                    case 2:
                        Game.ship().myNotebook().fields().add(new Field("Your New Pearl",
                        "The pearl is a classic pirate ship, focusing mostly on playing offense on the seas." + "`" +
                        "As a pearl, your ship will be designed to pillage and raid." + "`" +
                        "Your pearl must include:" + "`" +
                        "  ‣   At least three cannons" + "`" +
                        "  ‣   A way to board other ships" + "`" +
                        "  ‣   A treasure room for stolen goodies" + "`" +
                        "  ‣   Your own creative design for fighting other pirate ships"));

                        Game.setComponents(pearlComponents);
                        break;
                    case 3:
                        Game.ship().myNotebook().fields().add(new Field("Your New Ghoul",
                        "The Ghoul is a defensive ship filled with ghostly inhabitants." + "`" +
                        "As a Ghoul, your ship will be designed to fend off invaders and protect treasure." + "`" +
                        "Your Ghoul must include:" + "`" +
                        "  ‣   At least two traps" + "`" +
                        "  ‣   A protective layer for the ship’s deck" + "`" +
                        "  ‣   A scary flag of your own design to intimidate invaders"));

                        Game.setComponents(ghoulComponents);
                        break;
                }
                Game.ship().myNotebook().addFieldDate();
                Game.setScreen("Strategy Step 2 Screen");
            })
        };

        Sound[] myBackgroundSounds = {
            new Sound("SFX-Music/MUSIC-Ballerina.wav",'M',true,75.0f)
        };
        
        this.setCredits(myCredits);
        this.setButtons(myButtons);
        this.setBackgroundSounds(myBackgroundSounds);
    }

    public void drawScreenFeatures(Graphics g2d){
        
    }
}
