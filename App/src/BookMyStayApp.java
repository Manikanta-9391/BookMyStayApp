import java.util.*;
import java.util.stream.Collectors;

// Base class
abstract class Bogie {
    String id;

    public Bogie(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}

// Passenger Bogie
class PassengerBogie extends Bogie {
    String type; // Sleeper, AC Chair, First Class
    int capacity;

    public PassengerBogie(String id, String type, int capacity) {
        super(id);
        this.type = type;
        this.capacity = capacity;
    }

    public String getType() {
        return type;
    }
}

// Goods Bogie
class GoodsBogie extends Bogie {
    String cargoType; // Liquid, Solid

    public GoodsBogie(String id, String cargoType) {
        super(id);
        this.cargoType = cargoType;
    }

    public String getCargoType() {
        return cargoType;
    }
}

// Main Application
public class TrainConsistApp {

    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        // Sample Data
        bogies.add(new PassengerBogie("P1", "Sleeper", 72));
        bogies.add(new PassengerBogie("P2", "AC Chair", 60));
        bogies.add(new PassengerBogie("P3", "Sleeper", 72));
        bogies.add(new PassengerBogie("P4", "First Class", 40));

        bogies.add(new GoodsBogie("G1", "Liquid"));
        bogies.add(new GoodsBogie("G2", "Solid"));
        bogies.add(new GoodsBogie("G3", "Liquid"));
        bogies.add(new GoodsBogie("G4", "Solid"));

        // ===============================
        // 1. Group Passenger Bogies by Type
        // ===============================
        Map<String, List<PassengerBogie>> passengerGroups =
                bogies.stream()
                        .filter(b -> b instanceof PassengerBogie)
                        .map(b -> (PassengerBogie) b)
                        .collect(Collectors.groupingBy(PassengerBogie::getType));

        System.out.println("Passenger Bogies Grouped by Type:");
        passengerGroups.forEach((type, list) -> {
            System.out.println(type + " -> " + list.size() + " bogies");
        });

        System.out.println();

        // ===============================
        // 2. Group Goods Bogies by Cargo Type
        // ===============================
        Map<String, List<GoodsBogie>> goodsGroups =
                bogies.stream()
                        .filter(b -> b instanceof GoodsBogie)
                        .map(b -> (GoodsBogie) b)
                        .collect(Collectors.groupingBy(GoodsBogie::getCargoType));

        System.out.println("Goods Bogies Grouped by Cargo Type:");
        goodsGroups.forEach((cargo, list) -> {
            System.out.println(cargo + " -> " + list.size() + " bogies");
        });

        System.out.println();

        // ===============================
        // 3. Group All Bogies by Category
        // ===============================
        Map<String, List<Bogie>> categoryGroups =
                bogies.stream()
                        .collect(Collectors.groupingBy(b ->
                                (b instanceof PassengerBogie) ? "Passenger" : "Goods"
                        ));

        System.out.println("All Bogies Grouped by Category:");
        categoryGroups.forEach((category, list) -> {
            System.out.println(category + " -> " + list.size() + " bogies");
        });

        System.out.println();

        // ===============================
        // 4. Nested Grouping (Advanced)
        // ===============================
        Map<String, Map<String, List<Bogie>>> nestedGroups =
                bogies.stream()
                        .collect(Collectors.groupingBy(
                                b -> (b instanceof PassengerBogie) ? "Passenger" : "Goods",
                                Collectors.groupingBy(b -> {
                                    if (b instanceof PassengerBogie)
                                        return ((PassengerBogie) b).getType();
                                    else
                                        return ((GoodsBogie) b).getCargoType();
                                })
                        ));

        System.out.println("Nested Grouping:");
        nestedGroups.forEach((category, subMap) -> {
            System.out.println(category + ":");
            subMap.forEach((type, list) -> {
                System.out.println("  " + type + " -> " + list.size() + " bogies");
            });
        });
    }
}