package cso;

/**
 * title: SituationAssessment Class
 * @author cjscholl
 * version: 0.1.0
 * date: 09/21/21
 */
public class SituationAssessment extends CSOBase {

    /**
     * @param context the shared state of the CSO class that this SituationAssessment thread is tied to
     */
    public SituationAssessment (ProcessModel context) {
        super(context);
    }
    
    @Override
    public void run() {
        this.assess();
    }
    
    /**
     * Assess uses sensors to process events and determine the type of events that are occurring
     * This will have a loop to check if the process is done walking so it can shut down. 
     * It will get an x and y coordinate and determine the situation, using the Exchanger service.
     * It will determine how close the x,y pair is close to the border and which border it is closest to
     * Then it will inform the process model and plan generation thread that a new situation has happened.
     */
    private void assess() {
        
    }
    
}
