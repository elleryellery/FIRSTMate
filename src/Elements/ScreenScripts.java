package Elements;
import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import Structure.*;

public class ScreenScripts {
    public static void PullNotebookPageToTextBox(){
        GraphicsDatabase.I02.setContents(DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber).name());
        GraphicsDatabase.I03.setContents(DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber).entry());
    }

    

    public static void drawAt(int x, int y) {
        double resolution = Constants.mediumPen/DataCache.penSize;

        if(x > 312){
            switch(DataCache.penType){
                case "Scribble":
                    if(DataCache.previousCoordinate != null){
                        double xDist = Math.abs(DataCache.previousCoordinate.x() - x);
                        double yDist = Math.abs(DataCache.previousCoordinate.y() - y);
                        if(xDist > resolution && yDist > resolution){
                            //System.err.println("Starting a new connection.");
                            startPointConnection(10, x, y, DataCache.previousCoordinate.x(), DataCache.previousCoordinate.y());
                            //System.err.println("End connection.\n");
                        } else {
                            drawDisconnectedPoint(x, y);
                        }
                    } else {
                        drawDisconnectedPoint(x, y);
                    }
                    break;
                case "Erase":
                    ArrayList<Coordinate> temp = new ArrayList<Coordinate>(DataCache.drawing);
                    for(Coordinate c: DataCache.drawing){
                        Rectangle mouse = new Rectangle(x,y, DataCache.penSize, DataCache.penSize);
                        Rectangle coordinate = new Rectangle(c.x(),c.y(), DataCache.penSize, DataCache.penSize);

                        if(mouse.intersects(coordinate)){
                            temp.remove(c);
                        }
                    }
                    DataCache.drawing = temp;
                    break;
                case "Line":
                    if(DataCache.lineStart == null){
                        DataCache.lineStart = new Coordinate(x, y, DataCache.penColor, DataCache.penSize);
                        DataCache.previousCoordinate = DataCache.lineStart;
                    } else {
                        DataCache.lineEnd = new Coordinate(x, y, DataCache.penColor, DataCache.penSize);
                    }
            }
        }
        DataCache.myShip.retrieveData().ShipSketches[DataCache.componentIndex].savePoints(DataCache.drawing);
    }

    public static void liftLine(int x, int y){
        if(DataCache.penType.equals("Line") && DataCache.lineStart != null){
            makeLine();
            DataCache.lineStart = null;
            DataCache.lineEnd = null;
            DataCache.previousCoordinate = null;
        }
    }

    public static void makeLine(){
        if(DataCache.lineEnd.x()-DataCache.lineStart.x() != 0){
            if(DataCache.lineEnd.x()-DataCache.lineStart.x() < 0){
                Coordinate temp = DataCache.lineStart;
                DataCache.lineStart = DataCache.lineEnd;
                DataCache.lineEnd = temp;
                DataCache.previousCoordinate = DataCache.lineStart;
            }
            double m = (DataCache.lineEnd.y()-DataCache.lineStart.y())/(double)(DataCache.lineEnd.x()-DataCache.lineStart.x());
            
            for(int i = DataCache.lineStart.x(); i <= DataCache.lineEnd.x(); i++){
                Coordinate c = new Coordinate(i, (int)(m*(i-DataCache.lineStart.x())+DataCache.lineStart.y()), DataCache.penColor, DataCache.penSize);
                if(DataCache.previousCoordinate != null && Math.abs(m) > 7.0){
                    startPointConnection(3, c.x(), c.y(), DataCache.previousCoordinate.x(), DataCache.previousCoordinate.y());
                    DataCache.previousCoordinate = c;
                } else {
                    DataCache.drawing.add(c);
                }
            }
        } else {
            for(int i = DataCache.lineStart.y(); i <= DataCache.lineEnd.y(); i++){
                DataCache.drawing.add(new Coordinate(DataCache.lineStart.x(), i, DataCache.penColor, DataCache.penSize));
            }
        }
    }

    public static void drawDisconnectedPoint(int x, int y){
        DataCache.drawing.add(new Coordinate(x, y,  DataCache.penColor, DataCache.penSize));
        DataCache.previousCoordinate = DataCache.drawing.get(DataCache.drawing.size()-1);

    }


    public static void startPointConnection(int resolution, int goalX, int goalY, int x, int y){
        double xDist = goalX - x;
        double yDist = goalY - y;
        double distance = Math.sqrt(Math.pow(xDist, 2) + Math.pow(yDist, 2));
        double scale = resolution/distance;

        double xIncrement = xDist * scale;
        double yIncrement = yDist * scale;

        int numPoints = (int)(distance/resolution);

        for(int i = 0; i < numPoints; i++) {
            drawPoints(resolution, goalX, goalY, xIncrement, yIncrement);
        }
    }

    public static void drawPoints(int resolution, int goalX, int goalY, double xIncrement, double yIncrement){
        Coordinate prev = DataCache.previousCoordinate;

        int newX = (int)(prev.x() + xIncrement);
        int newY = (int)(prev.y() + yIncrement);

        Coordinate me = new Coordinate(newX, newY, DataCache.penColor, DataCache.penSize);
        DataCache.previousCoordinate = me;
        DataCache.drawing.add(me);
    }

    public static Draggable[] convertSketchesToDraggables(){
        Draggable[] temp = new Draggable[ DataCache.myShip.retrieveData().ShipSketches.length];

        int x = 0;
        int y = 0;

        for(int i = DataCache.myShip.retrieveData().ShipSketches.length - 1; i >= 0; i--){
            Drawing d = DataCache.myShip.retrieveData().sortedDrawings().get(i);
            if(d.x() == -3141592){
                x = 270 - d.width();
                y = 344 - (int)(d.height()/2);
            } else {
                x = d.x();
                y = d.y();
            }
            temp[i] = (new Draggable(x, y, d.width(), d.height(), d.asPicture()));
            d.giveDraggable(temp[i]);
        }

        return temp;
    }
}
