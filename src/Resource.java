/**
 * Created by Cassidy Tarng on 8/9/2018.
 */
public abstract class Resource extends LabResource{

    private int modelYear;
    private boolean statusActive;
    private double costOfMaintenance;

    public Resource(String resourceID, String supervisor,double costOfMaintenance, int modelYear){
        super(resourceID, supervisor);
        this.costOfMaintenance = costOfMaintenance;
        this.modelYear = modelYear;
        statusActive = true;
    }

    /**
     * @return costOfMaintenance
     */
    public double getCostOfMaintenance(){
        return costOfMaintenance;
    }

    /**
     * Prints the Resource Details
     */
    public void showResourceDetails(){
        System.out.println("Resource ID: " + getResourceID());
        System.out.println("Supervisor: " + getSupervisor());
        System.out.println("Model Year: " + modelYear);
        System.out.println("Status: " + statusActive);
    }

    /**
     *
     * @return true if model is older than given year, false if not
     */
    public boolean oldModel(int year){
        return modelYear < year;
    }

    /**
     * Sets the status to false
     */
    public void setInactive(){
        statusActive = false;
    }

    /**
     * @return active status
     */
    public boolean isActive(){ return statusActive; }
}
