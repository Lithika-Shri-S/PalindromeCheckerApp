import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class PalindromeCheckerApp {
    public static boolean isPalindromeUsingDeque(String input) {

        Deque<Character> deque = new LinkedList<>();

        // Insert all characters into deque
        for (int i = 0; i < input.length(); i++) {
            deque.addLast(input.charAt(i));
        }

        // Compare front and rear elements
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        if (isPalindromeUsingDeque(input)) {
            System.out.println("The given string is a palindrome.");
        } else {
            System.out.println("The given string is NOT a palindrome.");
        }

        scanner.close();
    }
}
