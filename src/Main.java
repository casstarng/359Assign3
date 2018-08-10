public class Main {

    public static void main(String[] args){
        Printer p1 = new Printer("Printer1", "Printer1", 50, 1990);
        WorkStation w1 = new WorkStation("Work1", "Work1", 50, 1990);
        WorkStation w2 = new WorkStation("Work1", "Work1", 50, 1990);
        LabResource cA = new ComputerCluster();
        cA.add(w1);
        cA.add(w2);
        cA.add(p1);

        Printer p2 = new Printer("Printer2", "Printer2", 50, 1990);
        LabResource cB = new ComputerCluster();
        cB.add(cA);
        cB.add(p2);

        System.out.println(cB.getCostOfMaintenance());
    }
}
