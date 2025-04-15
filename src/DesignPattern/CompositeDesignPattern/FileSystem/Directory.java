package CompositeDesignPattern.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{
    String directory;
    List<FileSystem> fileSystems;

    public Directory(String directory){
        this.directory = directory;
        fileSystems = new ArrayList<>();
    }

    public void add(FileSystem fileSystem){
        fileSystems.add(fileSystem);
    }

    @Override
    public void ls() {
        System.out.println("/"+directory); // Here is the benefit, no need to add check point.
        for(FileSystem fileSystem:fileSystems)
            fileSystem.ls();
    }
}
