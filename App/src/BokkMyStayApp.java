import java.util.HashMap;
import java.util.Map;

public class TrainConsistUC6 {

    public static void main(String[] args) {

        // Create a HashMap to store bogie names and their capacities
        HashMap<String, Integer> bogieCapacityMap = new HashMap<>();

        // Insert bogie-capacity mappings
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 60);
        bogieCapacityMap.put("First Class", 54);

        // Display all bogies with their capacities
        System.out.println("Bogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            System.out.println(entry.getKey() + " bogie has capacity: " + entry.getValue() + " seats");
        }

        // Example: Retrieve capacity by bogie name
        String bogieToCheck = "AC Chair";
        if (bogieCapacityMap.containsKey(bogieToCheck)) {
            System.out.println("\nCapacity of " + bogieToCheck + " bogie: " + bogieCapacityMap.get(bogieToCheck) + " seats");
        }
    }
}