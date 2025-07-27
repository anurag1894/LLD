package core;

import model.Directory;
import model.File;

public class FileSystem {
    private final Directory root;

    public FileSystem() {
        root = new Directory("/");
    }

    public void createPath(String path) {
        String[] parts = path.split("/");
        Directory curr = root;
        for (int i = 1; i < parts.length; i++) {
            String part = parts[i];
            IFileNode node = curr.getChild(part);
            if (node == null) {
                Directory newDir = new Directory(part);
                curr.addChild(part, newDir);
                curr = newDir;
            } else if (node.isDirectory()) {
                curr = (Directory) node;
            } else {
                throw new IllegalArgumentException("Path conflicts with file: " + path);
            }
        }
    }

    public void insertFile(String path, File file) {
        String[] parts = path.split("/");
        Directory curr = root;
        for (int i = 1; i < parts.length - 1; i++) {
            String part = parts[i];
            IFileNode node = curr.getChild(part);
            if (node == null || !node.isDirectory()) {
                throw new IllegalArgumentException("Invalid path: " + path);
            }
            curr = (Directory) node;
        }
        curr.addChild(parts[parts.length - 1], file);
    }

    public void deletePath(String path) {
        String[] parts = path.split("/");
        Directory curr = root;
        for (int i = 1; i < parts.length - 1; i++) {
            IFileNode node = curr.getChild(parts[i]);
            if (node == null || !node.isDirectory()) {
                throw new IllegalArgumentException("Invalid path: " + path);
            }
            curr = (Directory) node;
        }
        curr.removeChild(parts[parts.length - 1]);
    }

    public void display() {
        displayRecursive(root, "");
    }

    private void displayRecursive(IFileNode node, String indent) {
        System.out.println(indent + node.getName());
        if (node.isDirectory()) {
            Directory dir = (Directory) node;
            for (IFileNode child : dir.getChildren().values()) {
                displayRecursive(child, indent + "  ");
            }
        }
    }

}
