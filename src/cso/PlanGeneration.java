package cso;

/**
 * title: PlanGeneration Class
 * @author cjscholl
 * ver: 0.1.0
 * date: 09/21/21
 */
public class PlanGeneration extends CSOBase {

    /**
     * @param context the shared state of the CSO class that this PlanGeneration thread is tied to
     */
    public PlanGeneration (ProcessModel context) {
        super(context);
    }
    
    @Override
    public void run() {
        this.generate();
    }
    
    /**
     * Generate creates actions that intend to change the current state to the next state
     */
    private void generate() {
        
    }
    
}
