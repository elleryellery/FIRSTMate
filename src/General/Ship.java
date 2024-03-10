package General;

public class Ship {
    private String name;

    public Ship(){
        name = "No Name";
    }

    public Ship(String inputName){
        name = inputName;
        System.out.println(name);
    }
}
