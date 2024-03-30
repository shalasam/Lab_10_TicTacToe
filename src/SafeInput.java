import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int value = 0;
        boolean isValid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.nextLine(); // clear the buffer
            }
        } while (!isValid);
        return value;
    }

    public static double getDouble(Scanner pipe, String prompt) {
        double value = 0.0;
        boolean isValid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a double.");
                pipe.nextLine(); // clear the buffer
            }
        } while (!isValid);
        return value;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int value = 0;
        boolean isValid = false;
        do {
            value = getInt(pipe, prompt + " [" + low + " - " + high + "]");
            if (value >= low && value <= high) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter an integer within the specified range.");
            }
        } while (!isValid);
        return value;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double value = 0.0;
        boolean isValid = false;
        do {
            value = getDouble(pipe, prompt + " [" + low + " - " + high + "]");
            if (value >= low && value <= high) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a double within the specified range.");
            }
        } while (!isValid);
        return value;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input;
        boolean isValid = false;
        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            input = pipe.nextLine().toUpperCase();
            if (input.equals("Y") || input.equals("N")) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter 'Y' or 'N'.");
            }
        } while (!isValid);
        return input.equals("Y");
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String value;
        boolean isValid = false;
        do {
            value = getNonZeroLenString(pipe, prompt);
            if (value.matches(regEx)) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please follow the specified pattern.");
            }
        } while (!isValid);
        return value;
    }

    public static double CtoF(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static int getRangedInt(String s, int i, int i1) {
        return 0;
    }

}