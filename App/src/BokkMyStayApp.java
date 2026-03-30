import java.util.HashSet;

public class TrainConsistUC3 {

    public static void main(String[] args) {

        // Create a HashSet to store unique bogie IDs
        HashSet<String> bogieIds = new HashSet<>();

        // Adding bogie IDs (including duplicates intentionally)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // duplicate
        bogieIds.add("BG102"); // duplicate

        // Display all bogie IDs
        System.out.println("Unique Bogie IDs in the Train:");
        System.out.println(bogieIds);

        // Show size to prove duplicates are removed
        System.out.println("\nTotal Unique Bogies: " + bogieIds.size());
    }
}