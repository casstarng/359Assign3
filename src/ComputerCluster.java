import java.util.ArrayList;

/**
 * Created by Cassidy Tarng on 8/9/2018.
 */
public class ComputerCluster extends LabResource {

    private ArrayList<LabResource> labResources;
    private String clusterID;

    public ComputerCluster(String clusterID){
        super(clusterID);
        this.clusterID = clusterID;
        labResources = new ArrayList<>();
    }

    public ArrayList<LabResource> getLabResources(){
        return labResources;
    }

    /**
     * Add resource to list and set supervisor as new supervisor
     */
    public void add(LabResource labResource){
        labResources.add(labResource);
        setSupervisor(labResource.getSupervisor());
    }

    /**
     * @return Cost of maintenance in cluster
     */
    public double getCostOfMaintenance(){
        return getCostOfMaintenance(labResources);
    }

    /**
     * Helper method of calculating costOfMaintenance
     */
    private double getCostOfMaintenance(ArrayList<LabResource> labResources){
        double result = 0;
        for(LabResource l : labResources){
            // If resource is a leaf and active, add to cost
            if (l instanceof Resource){
                if (((Resource) l).isActive()){
                    result += l.getCostOfMaintenance();
                }
                else continue;
            }
            // If resource is a cluster, search through cluster
            else{
                result += getCostOfMaintenance(((ComputerCluster) l).getLabResources());
            }
        }
        return result;
    }

    /**
     * Removes the target resource
     */
    public void remove(LabResource target){
        remove(labResources, target);
    }

    /**
     * Helper method for remove
     */
    private void remove(ArrayList<LabResource> labResources, LabResource target){
        for(LabResource l : labResources){
            // If resource is a leaf and target matches, setInactive
            if (l instanceof Resource){
                if (l.getResourceID().equals(target.getResourceID())){
                    ((Resource) l).setInactive();
                    return;
                }
            }
            // If resource is a cluster and target matches, remove all resources under the cluster
            else if(l.getResourceID().equals(target.getResourceID())){
                removeAllUnderCluster(((ComputerCluster) l).getLabResources());
            }
            // If resource is a cluster and target doesn't match, search through cluster for target
            else{
                remove(((ComputerCluster) l).getLabResources(), target);
            }
        }
    }

    /**
     * Removes all resources under the given cluster
     */
    private void removeAllUnderCluster(ArrayList<LabResource> labResources){
        for(LabResource l : labResources){
            // If resource is of type Resource, set inactive
            if (l instanceof Resource) ((Resource) l).setInactive();
            // If resource is a cluster, go through cluster
            else{
                removeAllUnderCluster(((ComputerCluster) l).getLabResources());
            }
        }
    }

    /**
     * Prints resourceID of resources older than the year
     */
    public void showOlderModels(int year){
        showOlderModels(labResources, year);
    }

    /**
     * Helper method for showOlderModels
     */
    private void showOlderModels(ArrayList<LabResource> labResources, int year){
        for(LabResource l : labResources){
            // If resource is a leaf, active, and older, print
            if (l instanceof Resource){
                if (((Resource) l).isActive() && ((Resource) l).oldModel(year)){
                    System.out.println(l.getResourceID());
                }
                else continue;
            }
            // If resource is a cluster, search through cluster
            else{
                showOlderModels(((ComputerCluster) l).getLabResources(), year);
            }
        }
    }

    /**
     * Prints resource details of the cluster
     */
    public void showResourceDetails(){
        System.out.println("Cluster Resource ID: " + getResourceID());
        System.out.println("Cluster Supervisor: " + getSupervisor());
        System.out.println("----------------------------------");
        showResourceDetails(labResources);
    }

    /**
     * Helper method for showResourceDetails
     */
    private void showResourceDetails(ArrayList<LabResource> labResources){
        for(LabResource l : labResources){
            // If resource is a leaf and active, print details
            if (l instanceof Resource){
                if (((Resource) l).isActive()){
                    l.showResourceDetails();
                    System.out.println("----------------------------------");
                }
                else continue;
            }
            // If resource is a cluster, print details and resources
            else{
                System.out.println("Cluster Resource ID: " + l.getResourceID());
                System.out.println("Cluster Supervisor: " + l.getSupervisor());
                System.out.println("----------------------------------");
                showResourceDetails(((ComputerCluster) l).getLabResources());
            }
        }
    }
    
}
