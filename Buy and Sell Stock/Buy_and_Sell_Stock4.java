import java.util.*;

class Buy_and_Sell_Stock4 {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int prices[] = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        // int ans = Recursion(prices, 0, 0, 2 * k);
        int dp[][] = new int[n][2 * k];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        int ans = Memoization(prices, 0, 0, 2 * k, dp);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int prices[], int i, int x, int k) {
        if (i == prices.length) {
            return 0;
        }
        if (x == k)
            return 0;
        if (x % 2 == 0) {
            int take = -prices[i] + Recursion(prices, i + 1, x + 1, k);
            int nottake = Recursion(prices, i + 1, x, k);
            return Math.max(take, nottake);
        } else {
            int sell = prices[i] + Recursion(prices, i + 1, x + 1, k);
            int notsell = Recursion(prices, i + 1, x, k);
            return Math.max(sell, notsell);
        }
    }

    static int Memoization(int prices[], int i, int x, int k, int dp[][]) {
        if (i == prices.length) {
            return 0;
        }
        if (x == k)
            return 0;
        if (dp[i][x] != -1)
            return dp[i][x];
        if (x % 2 == 0) {
            int take = -prices[i] + Memoization(prices, i + 1, x + 1, k, dp);
            int nottake = Memoization(prices, i + 1, x, k, dp);
            return dp[i][x] = Math.max(take, nottake);
        } else {
            int sell = prices[i] + Memoization(prices, i + 1, x + 1, k, dp);
            int notsell = Memoization(prices, i + 1, x, k, dp);
            return dp[i][x] = Math.max(sell, notsell);
        }
    }
}