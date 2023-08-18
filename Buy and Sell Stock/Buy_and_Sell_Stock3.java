import java.util.*;

class Buy_and_Sell_Stock3 {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int prices[] = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        // int ans = Recursion(prices, 0, 0);
        int dp[][] = new int[n][4];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[i], -1);
        int ans = Memoization(prices, 0, 0, dp);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int prices[], int i, int x) {
        if (i == prices.length) {
            return 0;
        }
        if (x == 4)
            return 0;
        if (x % 2 == 0) {
            int take = -prices[i] + Recursion(prices, i + 1, x + 1);
            int nottake = Recursion(prices, i + 1, x);
            return Math.max(take, nottake);
        } else {
            int sell = prices[i] + Recursion(prices, i + 1, x + 1);
            int notsell = Recursion(prices, i + 1, x);
            return Math.max(sell, notsell);
        }
    }

    static int Memoization(int prices[], int i, int x, int dp[][]) {
        if (i == prices.length) {
            return 0;
        }
        if (x == 4)
            return 0;
        if (dp[i][x] != -1)
            return dp[i][x];
        if (x % 2 == 0) {
            int take = -prices[i] + Memoization(prices, i + 1, x + 1, dp);
            int nottake = Memoization(prices, i + 1, x, dp);
            return dp[i][x] = Math.max(take, nottake);
        } else {
            int sell = prices[i] + Memoization(prices, i + 1, x + 1, dp);
            int notsell = Memoization(prices, i + 1, x, dp);
            return dp[i][x] = Math.max(sell, notsell);
        }
    }
}