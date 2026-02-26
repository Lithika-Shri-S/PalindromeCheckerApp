import java.util.Scanner;

public class PalindromeCheckerApp {
    public static boolean isPalindromeUsingCharArray(String input) {

        // Convert string to character array
        char[] characters = input.toCharArray();

        int left = 0;
        int right = characters.length - 1;

        // Two-pointer comparison
        while (left < right) {
            if (characters[left] != characters[right]) {
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

        if (isPalindromeUsingCharArray(input)) {
            System.out.println("The given string is a palindrome.");
        } else {
            System.out.println("The given string is NOT a palindrome.");
        }

        scanner.close();
    }
}
