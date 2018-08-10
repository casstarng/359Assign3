import java.util.ArrayList;

/**
 * Created by Cassidy Tarng on 8/9/2018.
 */
public class ComputerCluster extends LabResource {

    private ArrayList<LabResource> labResources = new ArrayList<>();

    public ComputerCluster(){}

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

    public void remove(LabResource labResource){

    }

    
}
