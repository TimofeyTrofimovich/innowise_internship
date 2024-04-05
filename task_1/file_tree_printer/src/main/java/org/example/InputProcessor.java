package org.example;

import org.example.composites.VirtualUnit;

import java.util.Scanner;

public class InputProcessor {

    private final Scanner scanner;
    private final VirtualFileSystem virtualFileSystem;
    private boolean stop;

    public InputProcessor() {
        scanner = new Scanner(System.in);
        virtualFileSystem = new VirtualFileSystem();
    }

    public void run() {
        while (!stop) {
            System.out.print("$>");
            String input = scanner.nextLine();
            parseInput(input);
        }
    }

    private void parseInput(String input) {
            switch (input) {
                case "print" -> {
                    String result = virtualFileSystem.printStructure(new StringBuilder());
                    System.out.println(result);
                }
                case "exit" -> {
                    stop = true;
                }
                default -> {
                    String[] units = input.split("/");
                    if (!("root".equals(units[0]))) {
                        System.out.println("your input should have root directory");
                    } else {
                        VirtualUnit unit = virtualFileSystem.addOrGetUnit(virtualFileSystem.getRoot(), units[1]);
                        try {
                            for (int i = 2; i < units.length; i++) {
                                unit = virtualFileSystem.addOrGetUnit(unit, units[i]);
                            }
                        }
                        catch (UnsupportedOperationException e) {
                            System.out.println(e.getMessage());
                        }
                    }
                }
            }
    }
}
