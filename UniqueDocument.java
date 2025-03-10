public class UniqueDocument extends Document {
    private Employee employee;
    private String secretContent;

    // Constructor: Creates a UniqueDocument for a given employee and embeds a hidden mark.
    public UniqueDocument(String content, Employee employee) {
        super(content);
        this.employee = employee;
        this.secretContent = embedEmployeeId();
    }

    // Returns the employee associated with this document.
    public Employee getEmployee() {
        return employee;
    }

    /** Javadoc format kinda
     * Purpose: Embeds the employee's ID (converted to binary) into the document's content by modifying the spaces.
     * 
     * This method first converts the employee's ID into a 17 bit binary string (17 bits to fit all 5-digit numbers).
     * It then splits the original content into words and iterates over each word. For each gap between words,
     * the method uses a corresponding bit from the binary string, a 0 is represented by a single space, while
     * a 1 is represented by a double space. If the binary string has been fully embedded, any remaining gaps 
     * are filled with a single space.
     * 
     * @return The modified document content with the employee's binary ID embedded in the first 17 spaces. (String)
     */
    private String embedEmployeeId() {
        // Convert employee id to a fixed-length binary string.
        // A 5-digit number (max 99999) can be represented in at most 17 bits.
        int idValue = employee.getId();
        String binaryId = String.format("%17s", Integer.toBinaryString(idValue)).replace(' ', '0');

        // Split the original content into words.
        String[] words = content.split(" ");
        StringBuilder build = new StringBuilder();
        int bitsToEmbed = binaryId.length();
        int bitIndex = 0;

        // For each gap between words, use the corresponding bit:
        // '0' is a single space; '1' is a double space.
        for (int i = 0; i < words.length; i++) {  // Loop through each word in words
            build.append(words[i]); // Append the current word to stringbuilder
            if (i < words.length - 1) {  // If not the last word add a space
                if (bitIndex < bitsToEmbed) {  // Check if there are still bits left to embed
                    char bit = binaryId.charAt(bitIndex); // Retrieve the current bit from the binary employee id
                    build.append(bit == '1' ? "  " : " "); // Append a double space if the bit is '1' otherwise one space.
                    bitIndex++; 
                } else {  // if done embedding spaces
                    build.append(" ");  // add single spaces for the rest 
                }
            }
        }
        return build.toString();                                  
        
    }

    // Returns the marked content with the hidden employee id.
    public String getSecretContent() {
        return secretContent;
    }

    @Override
    public String toString() {
        return "UniqueDocument [Employee=" + employee + ", Marked Content=" + secretContent + "]";
    }
}
