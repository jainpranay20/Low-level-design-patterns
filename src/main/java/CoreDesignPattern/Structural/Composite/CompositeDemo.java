package CoreDesignPattern.Structural.Composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeDemo {

    // Common interface for both files and folders
    interface FileSystemComponent {
        void showDetails(String indent);
    }

    // Leaf node
    static class File implements FileSystemComponent {
        private final String name;

        public File(String name) {
            this.name = name;
        }

        @Override
        public void showDetails(String indent) {
            System.out.println(indent + "- File: " + name);
        }
    }

    // Composite node
    static class Folder implements FileSystemComponent {
        private final String name;
        private final List<FileSystemComponent> children = new ArrayList<>();

        public Folder(String name) {
            this.name = name;
        }

        public void add(FileSystemComponent component) {
            children.add(component);
        }

        public void remove(FileSystemComponent component) {
            children.remove(component);
        }

        @Override
        public void showDetails(String indent) {
            System.out.println(indent + "- Folder: " + name);
            for (FileSystemComponent child : children) {
                child.showDetails(indent + "  ");
            }
        }
    }

    public static void main(String[] args) {
        Folder root = new Folder("project");

        Folder src = new Folder("src");
        Folder docs = new Folder("docs");
        Folder apiDocs = new Folder("api");

        src.add(new File("Main.java"));
        src.add(new File("Utils.java"));

        apiDocs.add(new File("index.html"));
        apiDocs.add(new File("overview.md"));

        docs.add(new File("readme.md"));
        docs.add(new File("notes.txt"));
        docs.add(apiDocs);

        root.add(src);
        root.add(docs);
        root.add(new File("pom.xml"));

        System.out.println("Composite Design Pattern - File System Example");
        root.showDetails("");
    }
}
