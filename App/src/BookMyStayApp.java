import java.util.*;
import java.util.stream.Collectors;

public class TrainConsistApp {

    // Base class
    static abstract class Bogie {
        private String id;

        public Bogie(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

    // Passenger Bogie class
    static class PassengerBogie extends Bogie {
        private String type;
        private int capacity;

        public PassengerBogie(String id, String type, int capacity) {
            super(id);
            this.type = type;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }

        public String getType() {
            return type;
        }

        @Override
        public String toString() {
            return "Bogie ID: " + getId() +
                    ", Type: " + type +
                    ", Capacity: " + capacity;
        }
    }

    public static void main(String[] args) {

        // Step 1: Create list of bogies
        List<PassengerBogie> bogies = new ArrayList<>();

        bogies.add(new PassengerBogie("B1", "Sleeper", 72));
        bogies.add(new PassengerBogie("B2", "AC Chair", 45));
        bogies.add(new PassengerBogie("B3", "First Class", 30));
        bogies.add(new PassengerBogie("B4", "Sleeper", 80));
        bogies.add(new PassengerBogie("B5", "AC Chair", 50));

        // Step 2: Set capacity filter
        int minCapacity = 50;

        // Step 3: Apply Stream filtering
        List<PassengerBogie> filteredBogies = bogies.stream()
                .filter(b -> b.getCapacity() > minCapacity)
                .collect(Collectors.toList());

        // Step 4: Display results
        System.out.println("Passenger Bogies with capacity > " + minCapacity + ":\n");

        filteredBogies.forEach(System.out::println);
    }
}