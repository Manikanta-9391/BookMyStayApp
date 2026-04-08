import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistApp {

    // Passenger Bogie class
    static class PassengerBogie {
        private String bogieId;
        private String bogieType;
        private int seatingCapacity;

        public PassengerBogie(String bogieId, String bogieType, int seatingCapacity) {
            this.bogieId = bogieId;
            this.bogieType = bogieType;
            this.seatingCapacity = seatingCapacity;
        }

        public int getSeatingCapacity() {
            return seatingCapacity;
        }

        public String getBogieType() {
            return bogieType;
        }

        @Override
        public String toString() {
            return "Bogie ID: " + bogieId +
                    ", Type: " + bogieType +
                    ", Capacity: " + seatingCapacity;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Step 1: User creates list of bogies
        List<PassengerBogie> bogieList = new ArrayList<>();

        bogieList.add(new PassengerBogie("P1", "Sleeper", 72));
        bogieList.add(new PassengerBogie("P2", "AC Chair", 45));
        bogieList.add(new PassengerBogie("P3", "First Class", 30));
        bogieList.add(new PassengerBogie("P4", "Sleeper", 80));
        bogieList.add(new PassengerBogie("P5", "AC Chair", 55));

        // Step 2: Take input for filtering condition
        System.out.print("Enter minimum seating capacity to filter: ");
        int minCapacity = sc.nextInt();

        // Step 3: Convert list into stream and apply filter
        List<PassengerBogie> filteredBogies = bogieList.stream()
                .filter(b -> b.getSeatingCapacity() > minCapacity)
                .collect(Collectors.toList());

        // Step 4: Display filtered bogies
        System.out.println("\nFiltered Passenger Bogies:\n");

        if (filteredBogies.isEmpty()) {
            System.out.println("No bogies match the criteria.");
        } else {
            filteredBogies.forEach(System.out::println);
        }

        // Program continues...
        sc.close();
    }
}
