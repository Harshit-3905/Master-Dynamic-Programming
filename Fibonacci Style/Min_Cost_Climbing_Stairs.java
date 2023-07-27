import java.util.*;

class Min_Cost_Climbing_Stairs {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int cost[] = new int[n];
        for (int i = 0; i < n; i++)
            cost[i] = in.nextInt();
        // int ans = Recursion(cost, n);
        // int dp[] = new int[n + 1];
        // Arrays.fill(dp, -1);
        // int ans = Memoization(cost, n, dp);
        // int ans = Tabulation(cost, n);
        int ans = Space_Optimised(cost, n);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int[] cost, int n) {
        if (n == 0 || n == 1)
            return 0;
        return Math.min(cost[n - 1] + Recursion(cost, n - 1), cost[n - 2] + Recursion(cost, n - 2));
    }

    static int Memoization(int[] cost, int n, int dp[]) {
        if (n == 0 || n == 1)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        dp[n] = Math.min(cost[n - 1] + Recursion(cost, n - 1), cost[n - 2] + Recursion(cost, n - 2));
        return dp[n];
    }

    static int Tabulation(int[] cost, int n) {
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }
        return dp[n];
    }

    static int Space_Optimised(int[] cost, int n) {
        int curr = 0;
        int prev = 0;
        int prev1 = 0;
        for (int i = 2; i <= n; i++) {
            curr = Math.min(cost[i - 1] + prev, cost[i - 2] + prev1);
            prev1 = prev;
            prev = curr;
        }
        return curr;
    }
}