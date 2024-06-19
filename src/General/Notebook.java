package General;

import java.util.ArrayList;

public class Notebook {
    private ArrayList<Field> fields = new ArrayList<Field>();
    private ArrayList<String> fieldDates = new ArrayList<String>();

    public Notebook(){
        fields.add(new Field("Welcome to your new notebook!","This is your design notebook, where you'll record each step in your design process. Access this notebook from any step in the design process and make your own entries, if desired!"));
        addFieldDate();
    }
    public void addDefaultEntry(){
        fields.add(new Field("Demo Notebook", "You are currently viewing a demo notebook. The pages in this notebook are examples of what a notebook might look like in real life and may not exactly represent what a notebook will look like in the finalized game."));
        addFieldDate();
        fields.add(new Field("Your New Cruiser", 
                        "The cruiser is made for pirate fun!" + "`" +
                        "As a cruiser, your ship will be designed to give pirate riders a great time. Your cruiser must include:" + "`" +
                        "Your cruiser must include:" + "`" +
                        "  ‣   A restaurant" + "`" +
                        "  ‣   A movie theater" + "`" +
                        "  ‣   A party room" + "`" +
                        "  ‣   At least two other fun areas of your choosing!"));
        addFieldDate();
        fields.add(new Field("My Design Plan", 
                        "I want to make a ship that has a trap with maple syrup and also a bowling alley because my favorite food is syrup and I like bowling. I will need a lot of wood to make my ship. I thought about having a party room instead of a bowling alley but I thought about it more and decided that a bowling alley was better because multiple people can use it at once but there can only be one party."));
        addFieldDate();
        fields.add(new Field("Needs, Wants, Dreams", 
                        "I placed ship features in the following categores." + "`" + 
                        "Needs: " + "`" +
                        "  ‣   Three cannons" + "`" +
                        "  ‣   Ship hull" + "`" +
                        "Wants:" + "`" +
                        "  ‣   A tugboat that follows the ship around" + "`" +
                        "Dreams: " + "`" +
                        "  ‣   A bowling alley" + "`" +
                        "  ‣   A trap using maple syrup"
                        ));
        addFieldDate();
        fields.add(new Field("NWD List Reflection", 
                        "After making my list of Needs, Wants, and Dreams I decided to reevaluate my plan. Even though I really want a trap with maple syrup and a bowling alley they are something that I dream of having, so they aren't needs. I need to meet the requirements for my ship first."));
        addFieldDate();
    }
    public ArrayList<Field> fields() {
        return fields;
    }

    public ArrayList<String> fieldDates() {
        return fieldDates;
    }

    public void addFieldDate(){
        java.time.LocalDateTime date = java.time.LocalDateTime.now();
        fieldDates.add(date.getMonthValue() + "/" + date.getDayOfMonth() + "/" + date.getYear() + " " + date.getHour() + ":" + date.getMinute());
        System.out.println(fieldDates);
    }
}
