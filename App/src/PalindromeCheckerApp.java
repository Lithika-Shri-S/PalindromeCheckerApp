import java.util.Scanner;

public class PalindromeCheckerApp {
    public static boolean isPalindrome(String input) {

        // Step 1: Normalize the string
        String normalized = input.toLowerCase().replaceAll("\\s+", "");

        // Step 2: Check palindrome using two-pointer technique
        int left = 0;
        int right = normalized.length() - 1;

        while (left < right) {
            if (normalized.charAt(left) != normalized.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("The string is a palindrome (ignoring spaces & case).");
        } else {
            System.out.println("The string is NOT a palindrome.");
        }

        scanner.close();
    }
}
