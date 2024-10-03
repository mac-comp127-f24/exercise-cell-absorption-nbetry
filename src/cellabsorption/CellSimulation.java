package cellabsorption;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.Point;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.util.Random;

@SuppressWarnings("SameParameterValue")
public class CellSimulation {
   
    private CanvasWindow canvas;
    private Random rand = new Random();
    private List<Cell> cells;

    public static void main(String[] args) {
        new CellSimulation();
    }

    public CellSimulation() {
        canvas = new CanvasWindow("Cell Absorption", 800, 800);
        populateCells();

        //noinspection InfiniteLoopStatement
        while (true) {
            Point canvasCenter = new Point(canvas.getWidth() / 2.0, canvas.getHeight() / 2.0);
            for(Cell i : cells){
                i.moveAround(canvasCenter);
                handleCellInteraction();
                
            }
           

            canvas.draw();
            canvas.pause(10);
        }
    }

    private void populateCells() {
        double size = rand.nextInt(5) + 2;
        cells = new ArrayList<Cell> ();
        for(int i = 0; i<200; i++){
            Cell cell = new Cell(rand.nextDouble() * (canvas.getWidth() - size),
                rand.nextDouble() * (canvas.getWidth() - size),
                size,
                Color.getHSBColor(rand.nextFloat(), rand.nextFloat() * 0.5f + 0.1f, 1));
                canvas.add(cell.getShape());
                cells.add(cell);
                
        
        }
            
    }

    private void handleCellInteraction() {
        for(int i = 0; i < cells.size(); i++){
            Cell c1 = cells.get(i);
            for(int j= i+1; j<cells.size(); j++){
                Cell c2 = cells.get(j);
                c1.interactWith(c2);
            }
        }
        // for i from 0 up to max cell index
            // get cell at index i
            // for j from i+1 up to max cell index
                // get cell at index j
                // make the two cells interact
    }
    

    

    

    private static double sqr(double x) {
        return x * x;
    }

   
}
