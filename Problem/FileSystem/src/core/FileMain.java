package core;

import model.File;

public class FileMain {
    public static void main(String[] args) {
        FileSystem fs = new FileSystem();

        fs.createPath("/a/b/c");
        fs.createPath("/a/b/d");
        fs.insertFile("/a/b/c/file1.txt", new File("file1.txt"));
        fs.insertFile("/a/b/file2.txt", new File("file2.txt"));
        fs.insertFile("/a/b/d/file3.txt", new File("file3.txt"));
        fs.display();

       // fs.deletePath("/a/b/c/file1.txt");
        System.out.println("After deletion:");
        fs.display();
    }
}
