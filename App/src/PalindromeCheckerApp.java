import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheckerApp {
    // Public method exposed to client (Main method)
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Step 1: Normalize string (ignore spaces & case)
        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        // Step 2: Use Stack (Internal Data Structure)
        Stack<Character> stack = new Stack<>();

        // Push characters to stack
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        // Compare characters with popped values
        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}


// Main Application Class (User Interaction Layer)
public class PalindromeApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println("===== Palindrome Checker App (UC11) =====");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("Result: The string is a palindrome.");
        } else {
            System.out.println("Result: The string is NOT a palindrome.");
        }

        scanner.close();
    }
}
