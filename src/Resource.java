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

    public double getCostOfMaintenance(){
        return costOfMaintenance;
    }

    public void showResourceDetails(){
        System.out.println("Resource ID: " + getResourceID());
        System.out.println("Supervisor: " + getSupervisor());
        System.out.println("Model Year: " + modelYear);
        System.out.println("Status: " + statusActive);
    }

    public boolean oldModel(int year){
        return modelYear < year;
    }

    public void setInactive(){
        statusActive = false;
    }

    public boolean isActive(){ return statusActive; }
}
