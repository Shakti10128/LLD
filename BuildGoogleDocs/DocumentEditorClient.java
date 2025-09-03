package BuildGoogleDocs;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

// interface for Document elemetn
interface DocumentElement {
    public abstract String render();
}

// Concrete implementation for text element
class TextElement implements DocumentElement {
    private final String text;

    public TextElement(String text){
        this.text = text;
    }

    @Override
    public String render(){
        return text;
    }
}

// Concrete implementation for image element
class ImageElement implements DocumentElement {
    private final String imgPath;

    public ImageElement(String imgPath){
        this.imgPath = imgPath;
    }

    @Override
    public String render(){
        return "[Image: " + imgPath + "]";
    }
}

// NewLineElement represents a line break in the document.
class NewLineElement implements DocumentElement {
    @Override
    public String render() {
        return "\n";
    }
}

// TabSpaceElement represents a tab space in the document.
class TabSpaceElement implements DocumentElement {
    @Override
    public String render() {
        return "\t";
    }
}


// Document class responsible for holding a collection of elements
class Document{
    private List<DocumentElement> elements;

    // document will be having the all the elements like: text,image,tabSpace etc.....
    public Document(){
        this.elements = new ArrayList<>();
    }

    // client can add the and element like: text,image,tabSpace etc.....
    public void addElement(DocumentElement element) {
        this.elements.add(element);
    }

    // return the elements for rendering via another class
    public List<DocumentElement> getElements(){
        return this.elements;
    }
}

// Persistance interface
interface Persistence {
    public abstract void save(String document);
}

// FileStorage implementation of persistance
class FileStorage implements Persistence {
    @Override
    public void save(String document) {
        try {
            FileWriter outFile = new FileWriter("document.txt");
            outFile.write(document);
            outFile.close();
            System.out.println("Document saved to document.txt file");
        } catch (Exception e) {
            System.out.println("Error: Unable to open file for writing.");
        }
    }
}

// Placeholder DBStorage implementation
class DBStorage implements Persistence {
    @Override
    public void save(String document) {
        // Save to DB
    }
}

class DocumentRenderer{
    private final Document document;

    public DocumentRenderer(Document document) {
        this.document = document;
    }

    public String renderDocument(){
        StringBuilder result = new StringBuilder();
        // getting all the elements of the document
        List<DocumentElement> elements = this.document.getElements();
        for(DocumentElement doc: elements) {
            result.append(doc.render());
        }

        // return the result to the client for showing on Editory
        return result.toString();
    }
}

// DocumentEditor: In which the client will create multiple Documents
class DocumentEditor{
    private final Document document;
    private final Persistence storage;
    private final DocumentRenderer documentRenderer;

    public DocumentEditor(Document document,Persistence storage) {
        this.document = document;
        this.storage = storage;
        this.documentRenderer = new DocumentRenderer(this.document);
    }

    public void addText(String text){
        this.document.addElement(new TextElement(text));
    }

    public void addImage(String imgPath){
        this.document.addElement((new ImageElement(imgPath)));
    }

    public void addNewLine(){
        this.document.addElement(new NewLineElement());
    }

    public void addTabSpace(){
        this.document.addElement(new TabSpaceElement());
    }

    public void saveDocument() {
        this.storage.save(documentRenderer.renderDocument());
    }

    public void renderDocument(){
        System.out.println(this.documentRenderer.renderDocument());
    }
}



// Client UI: where client will interact with DocumentEditor
public class DocumentEditorClient {
    public static void main(String[] args) {
        // client created a new Document to write something
        Document document = new Document();

        // client want to save the document info in FileStorage
        Persistence fileStorage = new FileStorage();

        // Document Editor 
        DocumentEditor editor = new DocumentEditor(document,fileStorage);

        // Simulate a client using the editor with common text formatting features.
        editor.addText("Hello, world!");
        editor.addNewLine();
        editor.addText("This is a real-world document editor example.");
        editor.addNewLine();
        editor.addTabSpace();
        editor.addText("Indented text after a tab space.");
        editor.addNewLine();
        editor.addImage("picture.jpg");

        // Render and display the final document.
        editor.renderDocument();

        // document will be saved into FileStorage as per user requirement
        editor.saveDocument();
    }
}
