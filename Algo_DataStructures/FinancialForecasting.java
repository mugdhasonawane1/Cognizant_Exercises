public class FinancialForecasting {

    /**
     * Standard Recursive method to predict future value.
     * Time Complexity: O(n)
     * Space Complexity: O(n) (Call stack)
     * 
     * @param currentValue The current value.
     * @param growthRate The expected growth rate per period (e.g., 0.05 for 5%).
     * @param periods The number of periods to forecast into the future.
     * @return The predicted future value.
     */
    public static double predictFutureValue(double currentValue, double growthRate, int periods) {
        // Base case: If there are no periods left, the future value is the current value.
        if (periods <= 0) {
            return currentValue;
        }

        // Recursive step: Calculate the value for the next period and recurse.
        double nextPeriodValue = currentValue * (1 + growthRate);
        return predictFutureValue(nextPeriodValue, growthRate, periods - 1);
    }

    /**
     * Optimized helper method using Exponentiation by Squaring to avoid excessive recursion.
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     */
    public static double calculateGrowthMultiplier(double base, int exponent) {
        // Base case
        if (exponent == 0) {
            return 1.0;
        }
        
        // Recursive step
        double half = calculateGrowthMultiplier(base, exponent / 2);
        
        // If exponent is even
        if (exponent % 2 == 0) {
            return half * half;
        } 
        // If exponent is odd
        else {
            return base * half * half;
        }
    }

    /**
     * Optimized method to predict future value using O(log n) recursion.
     */
    public static double predictFutureValueOptimized(double currentValue, double growthRate, int periods) {
        return currentValue * calculateGrowthMultiplier(1 + growthRate, periods);
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05; // 5% growth rate
        int years = 10;
        
        System.out.println("Present Value: $" + presentValue);
        System.out.println("Expected Growth Rate: " + (growthRate * 100) + "% per year");
        System.out.println("Periods to forecast: " + years + " years");
        
        System.out.println("\n--- Standard Recursion ---");
        double futureValue1 = predictFutureValue(presentValue, growthRate, years);
        System.out.printf("Predicted Future Value: $%.2f%n", futureValue1);

        System.out.println("\n--- Optimized Recursion (Exponentiation by Squaring) ---");
        double futureValue2 = predictFutureValueOptimized(presentValue, growthRate, years);
        System.out.printf("Predicted Future Value: $%.2f%n", futureValue2);
    }
}
