package org.example;

import lombok.Getter;
import org.example.composites.VirtualDirectory;
import org.example.composites.VirtualFile;
import org.example.composites.VirtualUnit;

import java.util.Optional;

public class VirtualFileSystem {
    @Getter
    private VirtualDirectory root;

    public VirtualFileSystem() {
        this.root = new VirtualDirectory("root");
    }

    public String printStructure(StringBuilder sb) {
        root.printUnit(0, sb);
        return sb.toString();
    }

    public VirtualUnit addOrGetUnit(VirtualUnit parent, String unitName) throws UnsupportedOperationException {
        return unitName.contains(".")
                ? addFile(parent, unitName)
                : addOrGetDirectory(parent, unitName);
    }

    VirtualDirectory addOrGetDirectory(VirtualUnit parent, String newDirectoryName) throws UnsupportedOperationException {
        checkParent(parent);
        Optional<VirtualDirectory> optionalDir = ((VirtualDirectory)parent).getUnits()
                .stream()
                .filter(unit -> unit instanceof VirtualDirectory)
                .map(unit -> (VirtualDirectory) unit)
                .filter(dir -> dir.getName().equals(newDirectoryName))
                .findAny();
        if (optionalDir.isPresent()) {
            return optionalDir.get();
        }
        else {
            VirtualDirectory newDirectory = new VirtualDirectory(newDirectoryName);
            ((VirtualDirectory)parent).addUnit(newDirectory);
            return newDirectory;
        }
    }


    VirtualFile addFile(VirtualUnit parent, String filename) throws UnsupportedOperationException {
        checkParent(parent);
        VirtualFile file = new VirtualFile(filename);
            ((VirtualDirectory) parent).addUnit(file);
            return file;
    }


    private static void checkParent(VirtualUnit parent) {
        if (parent instanceof VirtualFile) {
            throw new UnsupportedOperationException("wrong input: forbidden to add smth into a file");
        }
    }
}
