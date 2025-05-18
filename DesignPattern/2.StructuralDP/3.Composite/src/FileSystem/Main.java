package FileSystem;

public class Main {
    public static void main(String[] args) {
        FileComponentSystem dir1 = new Directory("dir1");
        FileComponentSystem dir2 = new Directory("dir2");
        FileComponentSystem image1 = new File("image1");
        FileComponentSystem image2 = new File("image1");
        Directory dir3 = new Directory("dir3");
        dir3.add(dir2);
        dir3.add(dir1);
        dir3.add(image1);
        dir3.add(image2);
        FileComponentSystem dir4 = new Directory("dir4");
        Directory root = new Directory("root");
        root.add(dir3);
        root.add(dir4);

        dir3.showDetails();

        System.out.println("New print");
        dir1.showDetails();
        System.out.println("");
        System.out.println("New print");
        root.showDetails();

    }
}
