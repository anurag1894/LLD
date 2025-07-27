package model;

import core.IFileNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directory implements IFileNode {
    private final String name;
    private final Map<String, IFileNode> children = new HashMap<>();

    public Directory(String name) {
        this.name = name;
    }

    public void addChild(String name, IFileNode node) {
        children.put(name, node);
    }

    public IFileNode getChild(String name) {
        return children.get(name);
    }

    public void removeChild(String name) {
        children.remove(name);
    }

    public Map<String, IFileNode> getChildren() {
        return children;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isDirectory() {
        return true;
    }
}
