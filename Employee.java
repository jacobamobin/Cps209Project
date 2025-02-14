import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Employee {
    private String name;
    private int id;
    private static final Set<Integer> usedIds = new HashSet<>();

    public Employee(String name, int id) {
        this.name = name;
        this.id = generateUniqueID();
    }

    // This generates a unused 5-Digit ID for the employee
    private int generateUniqueID() {
        Random r = new Random();
        int newId;
        do {
            newId = 10000 + r.nextInt(90000); 
        } while (usedIds.contains(newId));
        usedIds.add(newId);
        return newId;
    }
}
