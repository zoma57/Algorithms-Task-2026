import java.util.Scanner;

public class BirthdayCakeCandlesRecursive {

    private static int solveRecursiveHelper(int[] candles, int index, int maxHeight, int count) {
        if (index == candles.length) {
            return count;
        }
        
        if (candles[index] > maxHeight) {
            return solveRecursiveHelper(candles, index + 1, candles[index], 1);
        } else if (candles[index] == maxHeight) {
            return solveRecursiveHelper(candles, index + 1, maxHeight, count + 1);
        } else {
            return solveRecursiveHelper(candles, index + 1, maxHeight, count);
        }
    }

    public static int solveRecursive(int[] candles) {
        if (candles == null || candles.length == 0) {
            return 0;
        }
        return solveRecursiveHelper(candles, 0, 0, 0);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Birthday Cake Candles (Recursive Algorithm) ---");
        System.out.print("Enter the number of candles: ");
        
        if (!scanner.hasNextInt()) {
            System.out.println("Error: Invalid input. Please enter an integer.");
            return;
        }
        
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Error: Number of candles must be greater than 0.");
            return;
        }

        int[] candles = new int[n];
        System.out.println("Enter the heights of the " + n + " candles (separated by space):");
        
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
                candles[i] = scanner.nextInt();
            } else {
                System.out.println("Error: Invalid candle height entered.");
                return;
            }
        }

        System.out.println("\n--- Processing Recursive Result ---");
        
        long startTime = System.nanoTime();
        int result = solveRecursive(candles);
        long endTime = System.nanoTime();
        
        System.out.println("Result: " + result);
        System.out.println("Execution Time: " + (endTime - startTime) + " nanoseconds.");

        scanner.close();
    }
}