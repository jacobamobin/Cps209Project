public class UniqueDocument extends Document {
    private Employee employee;
    private String markedContent;

    // Constructor: Creates a UniqueDocument for a given employee and embeds a hidden mark.
    public UniqueDocument(String content, Employee employee) {
        super(content);
        this.employee = employee;
        this.markedContent = embedEmployeeId();
    }

    // Returns the employee associated with this document.
    public Employee getEmployee() {
        return employee;
    }

    // Embeds the employee's ID (converted to binary) into the document by modifying the spaces.
    private String embedEmployeeId() {
        // Convert employee id to a fixed-length binary string.
        // A 5-digit number (max 99999) can be represented in 17 bits (2^17 = 131072).
        int idValue = employee.getId();
        String binaryId = String.format("%17s", Integer.toBinaryString(idValue)).replace(' ', '0');

        // Split the original content into words.
        String[] words = content.split(" ");
        StringBuilder sb = new StringBuilder();
        int bitsToEmbed = binaryId.length();
        int bitIndex = 0;

        // For each gap between words, use the corresponding bit:
        // '0' is a single space; '1' is a double space.
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i]);
            if (i < words.length - 1) {
                if (bitIndex < bitsToEmbed) {
                    char bit = binaryId.charAt(bitIndex);
                    sb.append(bit == '1' ? "  " : " ");
                    bitIndex++;
                } else {
                    // Once all bits are embedded, use a normal single space.
                    sb.append(" ");
                }
            }
        }
        return sb.toString();
    }

    // Returns the marked content with the hidden employee id.
    public String getMarkedContent() {
        return markedContent;
    }

    @Override
    public String toString() {
        return "UniqueDocument [Employee=" + employee + ", Marked Content=" + markedContent + "]";
    }
}
