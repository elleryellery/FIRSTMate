package Elements;
import Structure.*;

public class ScreenScripts {
    public static void PullNotebookPageToTextBox(){
        GraphicsDatabase.I02.setContents(DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber).name());
        GraphicsDatabase.I03.setContents(DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber).entry());

    }

    public static void drawAt(int x, int y) {
        double tolerance = 5;
        double resolution = 1;
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

            //System.out.println("You want to draw a point at (" + goalX + ", " + goalY + ") from (" + x + ", " + y + ")");
            //System.out.println("To do so, draw approximately " + numPoints + " points.");
            //System.out.println("I have set the increment values to the following: (" + xCrement + ", " + yCrement);
}

    public static void drawPoints(int resolution, int goalX, int goalY, double xIncrement, double yIncrement){
        Coordinate prev = DataCache.previousCoordinate;

        int newX = (int)(prev.x() + xIncrement);
        int newY = (int)(prev.y() + yIncrement);

        Coordinate me = new Coordinate(newX, newY, DataCache.penColor, DataCache.penSize);
        DataCache.previousCoordinate = me;
        DataCache.drawing.add(me);
        
    }
}
