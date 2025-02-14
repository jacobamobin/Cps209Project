public class Document {
    protected String content;

    // Constructor
    public Document(String content) {
        this.content = content;
    }

    // Getter
    public String getContent() {
        return content;
    }

    // Setter 
    public void setContent(String content) {
        this.content = content;
    }

    // Print the document content.
    public void display() {
        System.out.println(content);
    }

    @Override
    public String toString() {
        return "Document: " + content;
    }
}
