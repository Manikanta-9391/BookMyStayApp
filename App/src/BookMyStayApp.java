import java.util.*;
import java.util.stream.*;

abstract class Bogie {
    String id;

    public Bogie(String id) {
        this.id = id;
    }
}

// Passenger Bogie
class PassengerBogie extends Bogie {
    String type;
    int capacity;

    public PassengerBogie(String id, String type, int capacity) {
        super(id);
        this.type = type;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}

// Goods Bogie
class GoodsBogie extends Bogie {
    String shape; // Rectangular, Cylindrical

    public GoodsBogie(String id, String shape) {
        super(id);
        this.shape = shape;
    }
}

// Main App
public class TrainConsistAppUC10 {

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        // Sample Data
        bogies.add(new PassengerBogie("P1", "Sleeper", 72));
        bogies.add(new PassengerBogie("P2", "AC Chair", 60));
        bogies.add(new PassengerBogie("P3", "Sleeper", 72));
        bogies.add(new PassengerBogie("P4", "First Class", 40));

        bogies.add(new GoodsBogie("G1", "Rectangular"));
        bogies.add(new GoodsBogie("G2", "Cylindrical"));

        // ===============================
        // UC10: Total Seat Calculation
        // ===============================

        int totalSeats = bogies.stream()
                .filter(b -> b instanceof PassengerBogie)
                .map(b -> (PassengerBogie) b)
                .map(PassengerBogie::getCapacity)
                .reduce(0, (sum, capacity) -> sum + capacity);

        System.out.println("Total Seating Capacity of Train: " + totalSeats);
    }
}