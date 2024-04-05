package org.example.composites;

import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;


public class VirtualDirectoryTest {

    private VirtualDirectory dir = new VirtualDirectory("root");
    @Test
    void shouldPrintDirNameAndAllSubUnits() {
        VirtualDirectory dir1 = new VirtualDirectory("dir1");
        VirtualFile file1 = new VirtualFile("file1.txt");
        VirtualFile file2 = new VirtualFile("file2.txt");
        dir1.addUnit(file1);
        dir1.addUnit(file2);
        VirtualDirectory dir2 = new VirtualDirectory("dir2");
        VirtualDirectory dir3 = new VirtualDirectory("dir3");
        VirtualFile file3 = new VirtualFile("file3.txt");
        dir2.addUnit(file3);
        dir.addUnit(dir1);
        dir.addUnit(dir2);
        dir.addUnit(dir3);
        StringBuilder sb = new StringBuilder();
        dir.printUnit(0, sb);
        assertThat(sb.toString()).isEqualTo("""
                root/
                	dir1/
                		file1.txt
                		file2.txt
                	dir2/
                		file3.txt
                	dir3/
                """);
    }
}
