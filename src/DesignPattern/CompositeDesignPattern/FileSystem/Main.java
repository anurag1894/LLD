package CompositeDesignPattern.FileSystem;

public class Main {
    public static void main(String[] args) {
        Directory file = new Directory("user");
        FileSystem  file1 = new File("abc.txt");
        FileSystem  file2 = new File("def.txt");
        Directory  directory1 = new Directory("First");
        Directory  directory2 = new Directory("second");
        file.add(directory1);
        directory1.add(directory2);
        file.add(file1);
        directory1.add(file2);
        file.ls();
    }
}
