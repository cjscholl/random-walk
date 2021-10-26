/**
 * title: ProcessModel class
 * @author cjscholl
 * ver: 0.1.0
 * date: 09/21/21
 */
package cso;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import net.jcip.annotations.*;

@ThreadSafe
public class ProcessModel {
    private int x = 0;
    private int y = 0;
    private int steps = 0;
    // TODO implement process model
    // TODO implement 3 queues for pes, pgs, and sas messages/models
    
    public synchronized int getXCoordinate() {
        return this.x;
    }
    
    public synchronized int getYCoordinate() {
        return this.y;
    }
    
    public void moveEast() {
        takeStep(-1, 0);
    }
    
    public void moveWest() {
        takeStep(1, 0);
    }
    
    public void moveSouth() {
        takeStep(0, -1);
    }
    
    public void moveNorth() {
        takeStep(0, 1);
    }
    
    private synchronized void updateLocation(int deltaX, int deltaY) {
            this.x = this.x + deltaX;
            this.y = this.y + deltaY;
            
            this.steps++; // track number of steps
    }
    
    private void takeStep (int deltaX, int deltaY) {
        /**
             * Each step is a square with x and y coordinates. Previously visited steps leave behind white squares. 
             * This fills in the current visited step to white.
             */
            StdDraw.setPenColor(StdDraw.WHITE);
            StdDraw.filledSquare(x, y, 0.5);
            
            updateLocation(deltaX, deltaY);
            
            /**
             * Track the current next step with a black square and pauses between movements.
             */
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledSquare(x, y, 0.5);
            
            StdDraw.show();
            StdDraw.pause(1000);
    }
    public void startWalk() {
        /**
         * Set the x and y scale to the min-max of the same range. 
         * In this case the range is -10.5 to 10.5
         */
        int n = 10;
        StdDraw.setScale(-n - 0.5, n + 0.5);
        StdDraw.clear(StdDraw.GRAY); // set the background to gray
        
        /**
         * While the x and y coordinates remain in range of n (10),
         * keep looping to perform the walk
         */
        int steps = 0;
        while (Math.abs(this.getXCoordinate()) < n && Math.abs(this.getYCoordinate()) < n) {
            
            double r = Math.random();
            if (r < 0.25) moveEast(); // Go East
            else if (r < 0.50) moveWest(); // Go West
            else if (r < 0.75) moveSouth(); // Go South
            else if (r < 1.00) moveNorth(); // Go North
            
        }
        StdOut.println("Total steps = " + steps);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProcessModel context = new ProcessModel();
        context.startWalk();
        CSO cso = new CSO(context);
        new Thread(cso).start();
    }
}
