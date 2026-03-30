import java.util.LinkedHashSet;

public class TrainConsistUC5 {

    public static void main(String[] args) {

        // Create a LinkedHashSet to maintain unique bogies in insertion order
        LinkedHashSet<String> trainFormation = new LinkedHashSet<>();

        // Attach bogies (including a duplicate intentionally)
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");
        trainFormation.add("Sleeper"); // duplicate, will be ignored

        // Display final train formation
        System.out.println("Final Train Formation (Insertion Order Preserved, No Duplicates):");
        System.out.println(trainFormation);
    }
}