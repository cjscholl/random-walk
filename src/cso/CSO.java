/**
 * title: CSO Class
 * @author cjscholl
 * version: 0.1.0
 * date: 09/21/21
 */

package cso;

public class CSO extends CSOBase {

    /** 
     * SAS represents the CSO's situation assessment service, 
     * responsible for taking in sensory data and providing an assessment 
     */
    SituationAssessment sas;
    /** 
     * PGS represents the CSO's plan generation service, 
     * responsible for making plans and decisions based on assessments
     */
    PlanGeneration pgs;
    /** 
     * PES represents the CSO's plan execution service, 
     * responsible for executing decisions
     */
    PlanExecution pes;
    
    /**
     * @param context the shared state between all services in the CSO 
     * (SituationAssessment, PlanGeneration, and PlanExecution)
     */
    public CSO (ProcessModel context) {
        super(context);
        this.sas = new SituationAssessment(context);
        this.pgs = new PlanGeneration(context);
        this.pes = new PlanExecution(context);
    }
    
    /**
     * A method to start the CSO class and its services
     */
    @Override
    public void run() {
        new Thread(this.sas).start();
        new Thread(this.pgs).start();
        new Thread(this.pes).start();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProcessModel context = new ProcessModel();
        CSO cso = new CSO(context);
        new Thread(cso).start();
    }
    
}
