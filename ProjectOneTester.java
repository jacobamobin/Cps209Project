// NAME: Jacob Mobin
// STUDENTNUM: 501330782
// TMUEMAIL: jacob.mobin@torontomu.ca
// Class: CPS209 SECTION: 4
// DATE: Feb 13, 2025

/* PROJECT DESCRIPTION:
 * 
 * PROBLEM: You are running a massive company but your internal emails and memos keep getting leaked.
 * How do we find out whos leaking these memos, while the memos look (nearly) identical for every recipient.
 * Well, in 2008, tesla had the same problem, and they used a form of Steganography (Hiding secret messages in a message) to solve it
 * They sent out different emails to everyone in the company which has a unique combo of single and double spaces so that it can be traced back to a single recipient.
 * So my project will recreate this, and allow you to trace individual unique doccuments back to the individual it was sent to
 * 
 * 
 * CLASS DESCRIPTIONS:
 * Document:
 *    - A basic representation of a text document.
 *    - Holds the document's content and provides getters and setters.
 *    - Overrides toString() for a formatted representation.
 *
 * Employee:
 *    - Represents an employee with a name and a random unique 5-digit ID.
 *    - Overrides equals() and toString() for  comparison and representation.
 *
 * UniqueDocument (extends Document):
 *    - Extends/Inherits from Document and adds functionality to embed an employee's ID into a memo.
 *    - Converts the employee's ID into a binary string and encodes each bit into the spaces between first 17 words.
 *
 * ManageDocuments:
 *    - Manages collections of employees and unique documents.
 *    - Has functionality to add employees or documents, retrieve documents by employee, and display all documents.
 *
 * 
 * NOTE: The script only changes the first 17 spaces of a memo, i could have it cycle through and embed it everywhere hence
 * if only a portion of the memo gets leaked we can decode it, however ide have to account for a bunch of error correction ect
 * Plus it would likely make the user catch on while reading if there was weird spacing everywhere, 
 * So only submit the portion of the document that you want to be encoded, this could be the most confidential section of the memo.
 */



import java.util.List;

public class ProjectOneTester {
    public static void main(String[] args) {
        // Create a document manager
        ManageDocuments manager = new ManageDocuments();

        // Create some employees
        Employee emp1 = new Employee("Jacob");
        Employee emp2 = new Employee("Simon");
        Employee emp3 = new Employee("Owen");
        
        // Add employees to the manager
        manager.addEmployee(emp1);
        manager.addEmployee(emp2);
        manager.addEmployee(emp3);

        String sampleMemo = "As we conclude the first quarter of 2025, I want to take a moment to acknowledge our achievements and outline our strategic direction for the upcoming months. Our team’s exceptional performance has resulted in a 15% increase in overall revenue compared to the previous quarter, and our customer satisfaction ratings have improved significantly. This progress is a direct result of your unwavering commitment, innovation, and collaborative spirit. Looking forward, we have several new initiatives aimed at sustaining and accelerating this growth. First, we will expand our digital marketing efforts to reach a broader audience and improve brand engagement.";

        // Create documents with unique markings for each employee
        UniqueDocument memo1 = new UniqueDocument(sampleMemo, emp1);
        UniqueDocument memo2 = new UniqueDocument(sampleMemo, emp2);
        UniqueDocument memo3 = new UniqueDocument(sampleMemo, emp3);
        
        // Add documents to the manager
        manager.addDocument(memo1);
        manager.addDocument(memo2);
        manager.addDocument(memo3);

        // Display all stored documents (including hidden marks)
        System.out.println("All documents with embedded identifiers:");
        manager.displayAllDocuments();

        // Retrieve and display documents for a specific employee
        System.out.println("\nDocuments assigned to Alice:");
        List<UniqueDocument> aliceDocs = manager.getDocumentsByEmployee(emp1);
        for (UniqueDocument doc : aliceDocs) {
            System.out.println(doc);
        }

        // Demonstrate how a leaked document can be traced
        System.out.println("\nTracing a leaked document:");
        String leakedContent = memo2.getSecretContent();
        System.out.println("Leaked Document Content: " + leakedContent);
        System.out.println("Original Employee: " + memo2.getEmployee().getName() + " (ID: " + memo2.getEmployee().getId() + ")");
    }
}
