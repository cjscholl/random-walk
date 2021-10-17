
package cso;

/**
 * title: PlanExecution Class
 * @author cjscholl
 * ver: 0.1.0
 * date: 09/21/21
 */
public class PlanExecution extends CSOBase {

    /**
     * @param context the shared state of the CSO class that this PlanExecution thread is tied to
     */
    public PlanExecution (ProcessModel context) {
        super(context);
    }
    
    @Override
    public void run() {
        this.execute();
    }
    
    /**
     * Execute acts on plans generated and updates the process model context accordingly
     */
    private void execute() {
        
    }
    
}
