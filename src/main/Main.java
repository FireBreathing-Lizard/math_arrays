package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

public class Main {

    private static final String NO_VALUES = "No Value";
    private static final Logger LOGGER = Logger.getLogger("Main");

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println();
                Set<String> set1 = readMany(scanner, "A");
                Set<String> set2 = readMany(scanner, "B");
                printAll(set1, set2);
                printAorB(set1, set2);
                printAB(set1, set2);
                printAiB(set1, set2);
                System.exit(0);
            } catch (ConsoleException exception) {
                LOGGER.warning(exception.getMessage());
            } catch (Exception exception) {
                throw exception;
            }
        }
    }

    private static Set<String> readMany(Scanner scanner, String name) throws EmptyException {
        System.out.printf("%s = ", name);
        String scannedValue = scanner.nextLine().trim();
        if (scannedValue.isEmpty()) {
            throw new EmptyException();
        }

        String[] parts = scannedValue.split(" ");
        return new HashSet<>(Arrays.asList(parts));
    }

    private static String handleNoValue(Set<String> set) {
        return set.isEmpty() ? NO_VALUES :  set.toString();
    }

    private static void printAll(Set<String> set1, Set<String> set2) {
        System.out.println("A = " + set1);
        System.out.println("B = " + set2);
    }

    private static void printAorB(Set<String> set1, Set<String> set2) {
        set1.addAll(set2);
        System.out.println("A or B = " + handleNoValue(set1));
    }

    private static void printAB(Set<String> set1, Set<String> set2) {
        set1.removeAll(set2);
        System.out.println("A / B = " + handleNoValue(set1));
    }

    private static void printAiB(Set<String> set1, Set<String> set2) {
        set1.retainAll(set2);
        System.out.println("A and B = " + handleNoValue(set1));
    }
}