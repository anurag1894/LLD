package model;

import core.IFileNode;


public class File implements IFileNode {
    private final String name;
    private String content;

    public File(String name) {
        this.name = name;
        this.content = "";
    }

    public void write(String content) {
        this.content = content;
    }

    public String read() {
        return this.content;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }
}
