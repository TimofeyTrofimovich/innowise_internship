package org.example.composites;

import lombok.Getter;

@Getter
public abstract class VirtualUnit {

    public VirtualUnit(String name) {
        this.name = name;
    }
    protected String name;
    abstract void printUnit(int depth, StringBuilder sb);

}
