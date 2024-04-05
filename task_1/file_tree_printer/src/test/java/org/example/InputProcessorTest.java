package org.example;


import lombok.SneakyThrows;
import org.example.composites.VirtualDirectory;
import org.example.composites.VirtualUnit;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;


public class InputProcessorTest {

    @Test
    @SneakyThrows
    void shouldPrintFileTree() {
        InputProcessor inputProcessor = new InputProcessor();
        Method method = inputProcessor.getClass().getDeclaredMethod("parseInput", String.class);
        method.setAccessible(true);
        VirtualFileSystem fileSystem = Mockito.mock(VirtualFileSystem.class);
        Field field = inputProcessor.getClass().getDeclaredField("virtualFileSystem");
        field.setAccessible(true);
        field.set(inputProcessor, fileSystem);
        method.invoke(inputProcessor, "print");
        Mockito.verify(fileSystem, Mockito.times(1)).printStructure(any(StringBuilder.class));
    }


    @Test
    @SneakyThrows
    void shouldStop() {
        InputProcessor inputProcessor = new InputProcessor();
        Method method = inputProcessor.getClass().getDeclaredMethod("parseInput", String.class);
        method.setAccessible(true);
        method.invoke(inputProcessor, "stop");
        Field field = inputProcessor.getClass().getDeclaredField("stop");
        field.setAccessible(true);
        assertThat(field.get(inputProcessor)).isEqualTo(false);
    }


    @Test
    @SneakyThrows
    void shouldAddUnits() {
        InputProcessor inputProcessor = new InputProcessor();
        Method method = inputProcessor.getClass().getDeclaredMethod("parseInput", String.class);
        method.setAccessible(true);
        VirtualFileSystem fileSystem = Mockito.mock(VirtualFileSystem.class);
        Mockito.when(fileSystem.getRoot()).thenReturn(new VirtualDirectory("root"));
        Field field = inputProcessor.getClass().getDeclaredField("virtualFileSystem");
        field.setAccessible(true);
        field.set(inputProcessor, fileSystem);
        method.invoke(inputProcessor, "root/dir1/file1.txt");
        Mockito.verify(fileSystem, Mockito.times(1)).addOrGetUnit(any(VirtualUnit.class), any(String.class));
    }

}
