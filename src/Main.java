public class Main {

    public static void main(String[] args){
        Printer p1 = new Printer("Printer1", "Printer1", 50, 1990);
        WorkStation w1 = new WorkStation("Work1", "Work1", 50, 1990);
        WorkStation w2 = new WorkStation("Work2", "Work1", 50, 1990);
        ComputerCluster cA = new ComputerCluster("ClusterA");
        cA.add(w1);
        cA.add(w2);
        cA.add(p1);

        Printer p2 = new Printer("Printer2", "Printer2", 50, 1990);
        ComputerCluster cB = new ComputerCluster("ClusterB");
        cB.add(cA);
        cB.add(p2);

        //cB.showResourceDetails();
        cB.setInactive(cA.getResourceID());
        System.out.println(cB.getCostOfMaintenance());
    }
}
