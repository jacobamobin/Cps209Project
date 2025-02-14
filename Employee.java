import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Employee {
    private String name;
    private int id;
    private static final Set<Integer> usedIds = new HashSet<>();

    // Constructor
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

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void resetId() {
        this.id = generateUniqueID();
    }

    // .toString Override
    @Override
    public String toString() {
        return "Name: '" + name + "', RandomId: " + id;
    }

    // Equals Override
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        return name.equals(other.name);
    }

}
