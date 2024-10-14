package Structure;

import javax.swing.ImageIcon;

public class Draggable extends Button{
    public Draggable(){
        super();
    }

    public Draggable(String _tag, int _x, int _y, int _w, int _h){
        super(_tag, _x, _y, _w, _h, () -> {
            
        }); //TODO add default draggable script
    }

    public Draggable(int _x, int _y, int _w, int _h, ImageIcon image){
        super("000", _x, _y, _w, _h, () -> {
            
        }); //TODO add default draggable script

        this.overrideImage(image, image); //TODO modify regular image to indicate that it is being selected (e.g. add low-opacity white overlay)
    }

    public void snapTo(DragZone dragZone){
        int x = (int)(dragZone.width()/2 - this.w()/2) + dragZone.x();
        int y = (int)(dragZone.height()/2 - this.h()/2) + dragZone.y();

        this.setX(x);
        this.setY(y);
    }
}
