package General;

import java.util.ArrayList;

public class Notebook {
    private ArrayList<Field> fields = new ArrayList<Field>();
    private ArrayList<String> fieldDates = new ArrayList<String>();

    public Notebook(){
        fields.add(new Field("Welcome to your new notebook!","This is your design notebook, where you'll record each step in your design process. Access this notebook from any step in the design process and make your own entries, if desired!"));
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
