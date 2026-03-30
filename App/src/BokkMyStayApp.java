import java.util.ArrayList;

public class TrainConsistApp {

    public static void main(String[] args) {

        // Create an ArrayList to store passenger bogies
        ArrayList<String> passengerBogies = new ArrayList<>();

        // Adding bogies
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // Display bogies after insertion
        System.out.println("Passenger Bogies after addition:");
        System.out.println(passengerBogies);

        // Remove a bogie (AC Chair)
        passengerBogies.remove("AC Chair");

        // Display bogies after removal
        System.out.println("\nPassenger Bogies after removal:");
        System.out.println(passengerBogies);

        // Check if Sleeper bogie exists
        if (passengerBogies.contains("Sleeper")) {
            System.out.println("\nSleeper bogie is present in the train.");
        } else {
            System.out.println("\nSleeper bogie is NOT present in the train.");
        }

        // Final list state
        System.out.println("\nFinal Passenger Bogies List:");
        System.out.println(passengerBogies);
    }
}