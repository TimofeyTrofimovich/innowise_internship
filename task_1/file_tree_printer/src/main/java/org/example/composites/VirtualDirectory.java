package org.example.composites;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class VirtualDirectory extends VirtualUnit {

    @Getter
    private List<VirtualUnit> units;


    public VirtualDirectory(String name) {
        super(name);
        units = new ArrayList<>();
    }


    @Override
    public void printUnit(int depth, StringBuilder sb) {
        for (int i = 0; i < depth; i++) {
            sb.append("\t");
        }
        sb.append(name).append("/").append("\n");
        units.forEach(unit -> unit.printUnit(depth + 1, sb));
    }

    public void addUnit(VirtualUnit unit) {
        units.add(unit);
    }
}
