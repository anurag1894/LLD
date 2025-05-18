package FileSystem;

import CompositeDesignPattern.FileSystem.File;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileComponentSystem{
    private  String file;
    private List<FileComponentSystem> directoryList = new ArrayList<>();
    public Directory(String name) {
        this.file = name;
    }
    public void add(FileComponentSystem directory){
      this.directoryList.add(directory);
    }

    @Override
    public void showDetails() {
        System.out.println("Directory: " + file);
        for (FileComponentSystem component : directoryList) {
            component.showDetails();
        }
    }
}
