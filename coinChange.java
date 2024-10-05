import java.util.Arrays;

public class coinChange {
  // Function to find the minimum number of coins needed to make the
  // amount
  public static int coinChange(int[] coins, int amount) {
    // Create a dp array of size amount+1, initialized to a large
    // value (amount+1)
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1); // Since amount+1 is impossible, this
                                 // acts as "infinity"

    // Base case: to make 0, 0 coins are needed
    dp[0] = 0;

    // Iterate over each amount from 1 to the target amount
    for (int i = 1; i <= amount; i++) {
      // For each coin, check if it can be used to make the current
      // amount
      for (int coin : coins) {
        if (coin <= i) {
          dp[i] = Math.min(
              dp[i], dp[i - coin] + 1); // Minimize number of coins
        }
      }
    }

    // If the amount is still the initial large value, return -1
    // (impossible to make change)
    return dp[amount] > amount ? -1 : dp[amount];
  }

  public static void main(String[] args) {
    int[] coins = {1, 2, 5}; // Coin denominations
    int amount = 11; // Target amount
    int result = coinChange(coins, amount);

    if (result != -1) {
      System.out.println("Minimum coins required: " + result);
    } else {
      System.out.println(
          "Change cannot be made for the given amount.");
    }
  }
}
