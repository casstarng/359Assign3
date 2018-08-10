/**
 * Created by Cassidy Tarng on 8/9/2018.
 */
public abstract class LabResource {
    private String resourceID;
    private String supervisor;

    public LabResource(String resourceID, String supervisor){
        this.resourceID = resourceID;
        this.supervisor = supervisor;
    }

    public double getCostOfMaintenance(){
        throw new UnsupportedOperationException();
    }

    public void showResourceDetails(){
        throw new UnsupportedOperationException();
    }

    public void add(LabResource labResource){
        throw new UnsupportedOperationException();
    }

    public void remove(int id){
        throw new UnsupportedOperationException();
    }

    public String getResourceID(){
        return resourceID;
    }

    public String getSupervisor(){
        return supervisor;
    }
}
