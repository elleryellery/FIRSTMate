package Elements;
import Structure.*;

public class ScreenScripts {
    public static void PullNotebookPageToTextBox(){
        GraphicsDatabase.I02.setContents(DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber).name());
        GraphicsDatabase.I03.setContents(DataCache.myShip.myNotebook().entries().get(DataCache.pageNumber).entry());

    }

    public static void drawAt(int x, int y) {
        switch(DataCache.penType){
            case "Scribble":
                if(DataCache.connectPoints){
                    drawPoint(x, y, DataCache.previousCoordinate.x(), DataCache.previousCoordinate.y(), 0, 0);
                } else {
                    DataCache.drawing.add(new Coordinate(x, y,  DataCache.penColor, DataCache.penSize)); 
                    DataCache.previousCoordinate = DataCache.drawing.get(DataCache.drawing.size()-1);
                    DataCache.connectPoints = true;
                }
        }
    }

    public static void drawPoint(int goalX, int goalY, double x, double y, double x_increment, double y_increment){
        int resolution = 10;
        double xDist = goalX - x;
        double yDist = goalY - y;

        if(Math.abs(yDist) > resolution && Math.abs(xDist) > resolution){
            double yCrement;
            double xCrement;
            int xNeg = (int)(xDist/Math.abs(xDist));
            int yNeg = (int)(yDist/Math.abs(yDist));
            if(x_increment > 0 && y_increment > 0){
                xCrement = x_increment;
                yCrement = y_increment;
            } else {
                if(Math.abs(yDist) >= Math.abs(xDist)){
                    yCrement = resolution * yNeg;
                    xCrement = (Math.abs(yDist)/Math.abs(xDist)) * resolution * xNeg;
                } else {
                    xCrement = resolution * xNeg;
                    yCrement = (Math.abs(xDist)/Math.abs(yDist)) * resolution * yNeg;
                }
            }

            System.out.println(xCrement + " " + yCrement);

            double newx = x + xCrement;
            double newy = y + yCrement;
            System.out.println("Move point from (" + x + ", " + y + ") to (" + newx + ", " + newy + ") -- "  + xNeg + " " + yNeg);
            System.out.println("goalX: " + goalX + "; goalY: " + goalY + "; x: " + x + "; y: " + y + "; xDist: " + xDist + "; yDist: "+ yDist + "; xCrement: " + xCrement + "; yCrement: "+ yCrement);
            System.out.println("\n");

            DataCache.previousCoordinate = DataCache.drawing.get(DataCache.drawing.size()-1);
            DataCache.drawing.add(new Coordinate((int)newx, (int)newy,  DataCache.penColor, DataCache.penSize));
            drawPoint(goalX, goalY, newx, newy, xCrement, yCrement);
        }
    }
}
