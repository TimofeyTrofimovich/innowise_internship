package org.example.composites;

public class VirtualFile extends VirtualUnit {

    public VirtualFile(String name) {
        super(name);
    }

    @Override
    public void printUnit(int depth, StringBuilder sb) {
        for (int i = 0; i < depth; i++) {
            sb.append("\t");
        }
        sb.append(name).append("\n");
    }


}
