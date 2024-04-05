package org.example.composites;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class VirtualFileTest {
    private VirtualFile virtualFile;
    @Test
    void shouldPrintFileName() {
        virtualFile = new VirtualFile("name");
        StringBuilder stringBuilder = new StringBuilder();
        virtualFile.printUnit(3, stringBuilder);
        assertThat(stringBuilder.toString()).isEqualTo("\t\t\tname\n");
    }
}
