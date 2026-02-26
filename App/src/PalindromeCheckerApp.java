import java.util.*;

// Strategy Interface
interface PalindromeStrategy {
    boolean check(String input);
    String name(); // Return strategy name
}

// Stack Strategy
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        if (input == null) return false;
        String normalized = input.toLowerCase().replaceAll("\\s+", "");
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) stack.push(ch);
        for (char ch : normalized.toCharArray())
            if (ch != stack.pop()) return false;
        return true;
    }

    @Override
    public String name() {
        return "Stack Strategy";
    }
}

// Deque Strategy
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        if (input == null) return false;
        String normalized = input.toLowerCase().replaceAll("\\s+", "");
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : normalized.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1)
            if (!deque.removeFirst().equals(deque.removeLast())) return false;
        return true;
    }

    @Override
    public String name() {
        return "Deque Strategy";
    }
}

// Two-Pointer Strategy
class TwoPointerStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {
        if (input == null) return false;
        String normalized = input.toLowerCase().replaceAll("\\s+", "");
        char[] arr = normalized.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right)
            if (arr[left++] != arr[right--]) return false;
        return true;
    }

    @Override
    public String name() {
        return "Two-Pointer Strategy";
    }
}

// Performance Comparison App
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Palindrome Performance Comparison (UC13) =====");
        System.out.print("Enter a string to test: ");
        String input = scanner.nextLine();

        // List of strategies
        List<PalindromeStrategy> strategies = List.of(
                new StackStrategy(),
                new DequeStrategy(),
                new TwoPointerStrategy()
        );

        System.out.println("\nStrategy Performance Results:");
        System.out.printf("%-20s %-10s %-10s%n", "Strategy", "Palindrome?", "Time(ns)");

        // Run each strategy
        for (PalindromeStrategy strategy : strategies) {
            long startTime = System.nanoTime();
            boolean isPalindrome = strategy.check(input);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.printf("%-20s %-10s %-10d%n",
                    strategy.name(),
                    isPalindrome ? "Yes" : "No",
                    duration);
        }

        scanner.close();
    }
}