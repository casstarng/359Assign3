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

    public void add(LabResource labResource){
        labResources.add(labResource);
    }

    public double getCostOfMaintenance(){
        return getCostOfMaintenance(labResources);
    }

    private double getCostOfMaintenance(ArrayList<LabResource> labResources){
        double result = 0;
        for(LabResource l : labResources){
            if (l instanceof Resource){
                if (((Resource) l).isActive()){
                    result += l.getCostOfMaintenance();
                }
                else continue;
            }
            else{
                result += getCostOfMaintenance(((ComputerCluster) l).getLabResources());
            }
        }
        return result;
    }

    public void remove(LabResource target){
        remove(labResources, target);
    }

    private void remove(ArrayList<LabResource> labResources, LabResource target){
        for(LabResource l : labResources){
            if (l instanceof Resource){
                if (l.getResourceID().equals(target.getResourceID())){
                    ((Resource) l).setInactive();
                    return;
                }
            }
            else if(l.getResourceID().equals(target.getResourceID())){
                removeAllUnderCluster(((ComputerCluster) l).getLabResources());
            }
            else{
                remove(((ComputerCluster) l).getLabResources(), target);
            }
        }
    }

    private void removeAllUnderCluster(ArrayList<LabResource> labResources){
        for(LabResource l : labResources){
            if (l instanceof Resource) ((Resource) l).setInactive();
            else{
                removeAllUnderCluster(((ComputerCluster) l).getLabResources());
            }
        }
    }
    
}
