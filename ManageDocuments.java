import java.util.ArrayList;
import java.util.List;

public class ManageDocuments {
    private List<UniqueDocument> documents;
    private List<Employee> employees;

    // Constructor initializes the lists.
    public ManageDocuments() {
        documents = new ArrayList<>();
        employees = new ArrayList<>();
    }

    // Adds a new employee.
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    // Adds a new unique document.
    public void addDocument(UniqueDocument doc) {
        documents.add(doc);
    }

    // Retrieves all UniqueDocuments for a given employee.
    public List<UniqueDocument> getDocumentsByEmployee(Employee emp) {
        List<UniqueDocument> result = new ArrayList<>();
        for (UniqueDocument doc : documents) {
            if (doc.getEmployee().equals(emp)) {
                result.add(doc);
            }
        }
        return result;
    }

    // Displays all managed documents.
    public void displayAllDocuments() {
        for (UniqueDocument doc : documents) {
            System.out.println(doc);
        }
    }
}
