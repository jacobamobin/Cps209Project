# Document Steganography for Employee Identification

In 2008 Tesla had big problems with their internal emails getting leaked, they tracked the employee down by sending the same email to every employee with a different combo of single spaces and double spaced, and they fired the leaker that way, i thought this was cool so i build a program to recreate what they did.

## Overview

This project demonstrates a unique steganographic approach to prevent internal memos and emails from being leaked. By subtly altering the spaces between words in a document, the program embeds a hidden binary representation of an employee’s unique ID. When a document is leaked, this hidden signature can be extracted to trace the leak back to the individual who received the original memo.

Inspired by techniques reportedly used by Tesla in 2008, this project provides a practical solution to a common corporate security challenge—ensuring accountability for confidential communications.

## Problem Statement

Large companies often struggle with confidential information leaks. Traditional methods of watermarking may be too obvious or easily removed. Our solution takes a subtle approach: using steganography, we alter the spacing (i.e., single vs. double spaces) between words in a document to encode each recipient’s unique identifier.

## How It Works

1. **Employee Identification:**
   - Every employee is represented by an instance of the `Employee` class.
   - A unique 5-digit ID is automatically generated for each employee, ensuring no two employees share the same identifier.

2. **Document Creation:**
   - The `Document` class holds the basic content of a memo or email.
   - The `UniqueDocument` class extends `Document` to include the steganographic functionality. It embeds the employee’s unique ID into the document by modifying the spaces between words.
   - The employee's ID is converted to a fixed-length (17-bit) binary string. For each gap between words:
     - A single space represents a '0'.
     - A double space represents a '1'.
   - This encoding ensures that if any portion of the memo is leaked, the hidden ID can be recovered.

3. **Document Management:**
   - The `ManageDocuments` class acts as a central repository for both employees and documents. It allows adding new employees/documents, retrieving all documents for a given employee, and displaying the entire collection of documents.

4. **Testing & Demonstration:**
   - The `ProjectOneTester` class demonstrates the complete process:
     - It creates sample employees and unique documents.
     - It shows how the documents are stored.
     - It includes a demonstration of how a leaked document could be traced back to its originating employee by extracting the hidden ID.

5. **Decoding the Hidden ID:**
   - The decoding function (illustrated in our earlier example) scans the document for the spacing patterns.
   - It uses a simple algorithm (or regular expressions) to determine whether each space is single or double, reconstructing the binary sequence.
   - The first complete 17-bit cycle is converted back to an integer to identify the employee.
   - **Note:** In the enhanced cyclic embedding version, the binary string is repeated throughout the document, increasing robustness if only a portion of the text is leaked. The decoder must be updated accordingly to scan for complete cycles or use error correction mechanisms.

## Project Structure

- **Document.java**  
  A simple class that encapsulates text content and provides basic operations (getters, setters, display, and toString).

- **Employee.java**  
  Represents an employee with a unique name and 5-digit ID. The class also includes functionality to generate a unique identifier for each new employee.

- **UniqueDocument.java**  
  Extends `Document` to include steganographic functionality. It embeds an employee’s binary ID into the document by manipulating the spacing between words.

- **ManageDocuments.java**  
  Manages collections of both `UniqueDocument` instances and `Employee` objects. It provides methods to add new employees/documents, retrieve documents by employee, and display all documents.

- **ProjectOneTester.java**  
  The main class that ties everything together. It demonstrates creating employees, generating uniquely marked documents, and tracing a leaked document back to its source.

## Setup & Running the Program

### Prerequisites

- **Java JDK:** Make sure you have JDK 8 or higher installed on your system.
- **IDE or Text Editor:** You can use any Java IDE (e.g., IntelliJ, Eclipse) or a simple text editor with command-line compilation.

### Compilation & Execution

1. **Compile the Code:**  
   Open your terminal (or IDE terminal) and compile all Java files:
   ```bash
   javac *.java
   ```

2. **Run the Application:**  
   Execute the main tester class:
   ```bash
   java ProjectOneTester
   ```
   The program will display:
   - A list of all documents with their embedded unique identifiers.
   - A specific example of how a leaked document is traced back to the respective employee.

## Future Enhancements

- **Cyclic Embedding & Robust Decoding:**  
  Implement a cyclic embedding strategy where the binary ID is repeated throughout the document. This approach can improve reliability when only parts of the document are leaked. The corresponding decoder can be enhanced with error correction or majority voting to ensure accurate ID recovery.

- **Graphical User Interface (GUI):**  
  A future version might include a GUI for non-technical users to easily manage documents and employees.

- **Extended Metadata:**  
  Embed additional metadata such as timestamps or department codes along with the employee ID to enhance traceability.

- **Security Enhancements:**  
  Introduce advanced cryptographic techniques or error-correcting codes to further secure and verify the integrity of the hidden data.

## Conclusion

This project provides a robust, stealthy way to embed and later extract an employee's unique identifier from confidential documents using steganography. It demonstrates not only practical coding techniques (such as string manipulation and cyclic embedding) but also offers a glimpse into how subtle modifications can significantly bolster information security in corporate communications.

---

If you have any questions or suggestions, please feel free to reach out!

Happy coding!
