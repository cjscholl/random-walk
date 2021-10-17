package cso;

/**
 * title: CSO Base Class
 * @author cjscholl
 * ver: 0.1.0
 * date: 09/21/21
 */
public abstract class CSOBase implements Runnable {
    ProcessModel context;
    
    /**
     * @param context the shared state between all services in the CSO 
     * (SituationAssessment, PlanGeneration, and PlanExecution). Context
     * is defined in the CSOBase class so that each CSO child will have
     * a reference to the process model.
     */
    public CSOBase(ProcessModel context) {
        this.context = context;
    }
    
    public abstract void run();
}
