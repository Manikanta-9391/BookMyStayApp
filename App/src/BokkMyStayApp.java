import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Bogie class with name and capacity
class Bogie {
    private String name;
    private int capacity;

    public Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (" + capacity + " seats)";
    }
}

public class TrainConsistUC7 {

    public static void main(String[] args) {

        // Create a List to store passenger bogies
        List<Bogie> passengerBogies = new ArrayList<>();

        // Add bogies with capacities
        passengerBogies.add(new Bogie("Sleeper", 72));
        passengerBogies.add(new Bogie("AC Chair", 60));
        passengerBogies.add(new Bogie("First Class", 54));

        System.out.println("Passenger Bogies before sorting:");
        passengerBogies.forEach(System.out::println);

        // Sort bogies by capacity using Comparator
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity));

        System.out.println("\nPassenger Bogies after sorting by capacity:");
        passengerBogies.forEach(System.out::println);

        // Optional: sort in descending order
        passengerBogies.sort(Comparator.comparingInt(Bogie::getCapacity).reversed());
        System.out.println("\nPassenger Bogies sorted by descending capacity:");
        passengerBogies.forEach(System.out::println);
    }
}