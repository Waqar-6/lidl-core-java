package input;

import java.util.Scanner;

public final class InputHandler {
    private InputHandler() {}

    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt) {
        System.out.println(prompt + " : ");
//        scanner.nextLine(); // Clear any leftover newline characters
        return scanner.nextLine(); // Use nextLine() instead of next()
    }

    public static Long readLong(String prompt) {
        System.out.println(prompt + " : ");
        while (true) {
            try {
                String input = scanner.nextLine();
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number: ");
            }
        }
    }

    public static int readInt(String prompt) {
        System.out.println(prompt + " : ");
        while (true) {
            try {
                String input = scanner.nextLine();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number: ");
            }
        }
    }
}