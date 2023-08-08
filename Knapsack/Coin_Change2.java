import java.util.*;

class Coin_Change2 {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int amount = in.nextInt();
        int coins[] = new int[n];
        for (int i = 0; i < n; i++)
            coins[i] = in.nextInt();
        // int ans = Recursion(amount, n - 1, coins);
        // int dp[][] = new int[n][amount + 1];
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j <= amount; j++)
        // dp[i][j] = -1;
        // }
        // int ans = Memoization(amount, n - 1, coins, dp);
        // int ans = Tabulation(coins, amount);
        // int ans = Space_Optimised(coins, amount);
        int ans = Space_Optimised1(coins, amount);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int amount, int x, int[] coins) {
        if (x == 0) {
            if (amount % coins[x] == 0)
                return 1;
            else
                return 0;
        }
        int take = 0;
        if (coins[x] <= amount) {
            take = Recursion(amount - coins[x], x, coins);
        }
        int nottake = Recursion(amount, x - 1, coins);
        return take + nottake;
    }

    static int Memoization(int amount, int x, int[] coins, int[][] dp) {
        if (x == 0) {
            if (amount % coins[x] == 0)
                return 1;
            else
                return 0;
        }
        if (dp[x][amount] != -1)
            return dp[x][amount];
        int take = 0;
        if (coins[x] <= amount) {
            take = Memoization(amount - coins[x], x, coins, dp);
        }
        int nottake = Memoization(amount, x - 1, coins, dp);
        return dp[x][amount] = take + nottake;
    }

    static int Tabulation(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];
        for (int amt = 0; amt <= amount; amt++)
            if (amt % coins[0] == 0)
                dp[0][amt] = 1;
        for (int x = 1; x < n; x++) {
            for (int amt = 0; amt <= amount; amt++) {
                int take = 0;
                if (coins[x] <= amt)
                    take = dp[x][amt - coins[x]];
                int nottake = dp[x - 1][amt];
                dp[x][amt] = take + nottake;
            }
        }
        return dp[n - 1][amount];
    }

    static int Space_Optimised(int coins[], int amount) {
        int n = coins.length;
        int prev[] = new int[amount + 1];
        int curr[] = new int[amount + 1];
        for (int amt = 0; amt <= amount; amt++)
            if (amt % coins[0] == 0)
                prev[amt] = 1;
        for (int x = 1; x < n; x++) {
            for (int amt = 0; amt <= amount; amt++) {
                int take = 0;
                if (coins[x] <= amt)
                    take = curr[amt - coins[x]];
                int nottake = prev[amt];
                curr[amt] = take + nottake;
            }
            prev = curr.clone();
        }
        return prev[amount];
    }

    static int Space_Optimised1(int coins[], int amount) {
        int n = coins.length;
        int dp[] = new int[amount + 1];
        for (int amt = 0; amt <= amount; amt++)
            if (amt % coins[0] == 0)
                dp[amt] = 1;
        for (int x = 1; x < n; x++) {
            for (int amt = 0; amt <= amount; amt++) {
                int take = 0;
                if (coins[x] <= amt)
                    take = dp[amt - coins[x]];
                int nottake = dp[amt];
                dp[amt] = take + nottake;
            }
        }
        return dp[amount];
    }
}
