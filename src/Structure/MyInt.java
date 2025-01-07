package Structure;

public class MyInt {
    private int num;

    public MyInt(int number){
        num = number;
    }

    public void setNumber(int number){
        num = number;
    }

    public void setNumber(String number){
        num = Integer.parseInt(number);
    }

    public int getNumber(){
        return num;
    }

    public String toString(){
        return num + "";
    }
}
