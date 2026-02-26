import java.util.Scanner;

public class PalindromeCheckerApp {
    public static boolean isPalindromeRecursive(String input, int start, int end) {

        // Base Condition
        if (start >= end) {
            return true;
        }

        // If characters don't match
        if (input.charAt(start) != input.charAt(end)) {
            return false;
        }

        // Recursive call for inner substring
        return isPalindromeRecursive(input, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        boolean result = isPalindromeRecursive(input, 0, input.length() - 1);

        if (result) {
            System.out.println("The given   - string is a palindrome.");
        } else {
            System.out.println("The given string is NOT a palindrome.");
        }

        scanner.close();
    }
}
