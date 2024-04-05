package org.example;

import org.example.composites.VirtualDirectory;
import org.example.composites.VirtualFile;
import org.example.composites.VirtualUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import static org.assertj.core.api.Assertions.assertThat;



public class VirtualFileSystemTest {

    private VirtualFileSystem virtualFileSystem = new VirtualFileSystem();

    @Test
    void shouldTryToSaveFile() {
        VirtualFileSystem spy = Mockito.spy(VirtualFileSystem.class);
        VirtualUnit parent = new VirtualDirectory("parent");
        spy.addOrGetUnit(parent, "file1.txt");
        Mockito.verify(spy, Mockito.times(1)).addFile(parent, "file1.txt");
    }

    @Test
    void shouldThrowExceptionWhenParentIsFile() {
        UnsupportedOperationException exception1 = Assertions.assertThrows(UnsupportedOperationException.class,
                () -> virtualFileSystem.addOrGetUnit(new VirtualFile("file"), "file"));
        assertThat(exception1.getMessage()).isEqualTo("wrong input: forbidden to add smth into a file");

        UnsupportedOperationException exception2 = Assertions.assertThrows(UnsupportedOperationException.class,
                () -> virtualFileSystem.addOrGetDirectory(new VirtualFile("file"), "file"));
        assertThat(exception2.getMessage()).isEqualTo("wrong input: forbidden to add smth into a file");
    }

    @Test
    void shouldAddFileToTheParent() {
        VirtualDirectory dir = new VirtualDirectory("dir");
        virtualFileSystem.addFile(dir, "file.txt");
        assertThat(dir.getUnits().get(0).getName()).isEqualTo("file.txt");
        assertThat(dir.getUnits().get(0)).isInstanceOf(VirtualFile.class);
    }

    @Test
    void shouldAddDirToTheParent() {
        VirtualDirectory dir = new VirtualDirectory("dir");
        virtualFileSystem.addOrGetDirectory(dir, "dir1");
        assertThat(dir.getUnits().get(0).getName()).isEqualTo("dir1");
        assertThat(dir.getUnits().get(0)).isInstanceOf(VirtualDirectory.class);
    }

    @Test
    void shouldFindDirAndReturnIt() {
        VirtualDirectory dir = new VirtualDirectory("dir");
        VirtualDirectory dir1 = new VirtualDirectory("dir1");
        dir.addUnit(dir1);
        VirtualDirectory foundDir = virtualFileSystem.addOrGetDirectory(dir, "dir1");
        assertThat(dir.getUnits().size()).isEqualTo(1);
        assertThat(foundDir).isEqualTo(dir1);
    }
}
