package input;

import java.util.Scanner;

public final class InputHandler {

    private InputHandler () {}

    public static final Scanner scanner = new Scanner(System.in);

    public static String readString (String prompt) {
        System.out.println(prompt+" : ");
        return scanner.next();
    }

    public static Long readLong (String prompt) {
        System.out.println(prompt+" : ");
        return scanner.nextLong();
    }

    public static int readInt (String prompt) {
        System.out.println(prompt+" : ");
        return scanner.nextInt();
    }
}