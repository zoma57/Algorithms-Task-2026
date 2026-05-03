import java.util.Scanner;

public class BirthdayCakeCandlesIterative {

    public static int solveIterative(int[] candles) {
        int maxHeight = 0;
        int count = 0;
        
        for (int i = 0; i < candles.length; i++) {
            if (candles[i] > maxHeight) {
                maxHeight = candles[i];
                count = 1;
            } else if (candles[i] == maxHeight) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Birthday Cake Candles (Iterative Algorithm) ---");
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

        System.out.println("\n--- Processing Iterative Result ---");
        
        long startTime = System.nanoTime();
        int result = solveIterative(candles);
        long endTime = System.nanoTime();
        
        System.out.println("Result: " + result);
        System.out.println("Execution Time: " + (endTime - startTime) + " nanoseconds.");

        scanner.close();
    }
}