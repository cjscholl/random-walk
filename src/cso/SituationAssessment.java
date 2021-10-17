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
     */
    private void assess() {
        
    }
    
}
