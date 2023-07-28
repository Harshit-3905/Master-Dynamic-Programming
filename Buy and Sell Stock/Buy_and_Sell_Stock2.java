import java.util.*;

class Buy_and_Sell_Stock2 {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int prices[] = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        // int ans = Recursion(prices, 0, 0);
        int dp[][] = new int[n][2];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        // int ans = Memoization(prices, 0, 0, dp);
        // int ans = Tabulation(prices, n);
        int ans = Space_Optimised(prices, n);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int[] prices, int i, int ch) {
        if (i == prices.length)
            return 0;
        if (ch == 0) {
            int buy = -prices[i] + Recursion(prices, i + 1, 1);
            int notbuy = Recursion(prices, i + 1, 0);
            return Math.max(buy, notbuy);
        } else {
            int sell = prices[i] + Recursion(prices, i + 1, 0);
            int notsell = Recursion(prices, i + 1, 1);
            return Math.max(sell, notsell);
        }
    }

    static int Memoization(int[] prices, int i, int ch, int[][] dp) {
        if (i == prices.length)
            return 0;
        if (dp[i][ch] != -1)
            return dp[i][ch];
        if (ch == 0) {
            int buy = -prices[i] + Memoization(prices, i + 1, 1, dp);
            int notbuy = Memoization(prices, i + 1, 0, dp);
            dp[i][ch] = Math.max(buy, notbuy);
            return dp[i][ch];
        } else {
            int sell = prices[i] + Memoization(prices, i + 1, 0, dp);
            int notsell = Memoization(prices, i + 1, 1, dp);
            dp[i][ch] = Math.max(sell, notsell);
            return dp[i][ch];
        }
    }

    static int Tabulation(int prices[], int n) {
        int dp[][] = new int[n][2];
        dp[n - 1][1] = prices[n - 1];
        dp[n - 1][0] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int buy = -prices[i] + dp[i + 1][1];
            int notbuy = dp[i + 1][0];
            dp[i][0] = Math.max(buy, notbuy);
            int sell = prices[i] + dp[i + 1][0];
            int notsell = dp[i + 1][1];
            dp[i][1] = Math.max(sell, notsell);
        }
        return dp[0][0];
    }

    static int Space_Optimised(int prices[], int n) {
        int dp[] = new int[2];
        dp[1] = prices[n - 1];
        dp[0] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int buy = -prices[i] + dp[1];
            int notbuy = dp[0];
            dp[0] = Math.max(buy, notbuy);
            int sell = prices[i] + dp[0];
            int notsell = dp[1];
            dp[1] = Math.max(sell, notsell);
        }
        return dp[0];
    }

}