import java.util.*;

class Nth_Tribonacci_Problem {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // int ans = Recursion(n);
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        // int ans = Memoization(n, dp);
        // int ans = Tabulation(n);
        int ans = Space_Optimised(n);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int n) {
        if (n == 0 || n == 1)
            return n;
        if (n == 2)
            return 1;
        return Recursion(n - 1) + Recursion(n - 2) + Recursion(n - 3);
    }

    static int Memoization(int n, int dp[]) {
        if (n == 0 || n == 1)
            return n;
        if (n == 2)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        dp[n] = Memoization(n - 1, dp) + Memoization(n - 2, dp) + Memoization(n - 3, dp);
        return dp[n];
    }

    static int Tabulation(int n) {
        int dp[] = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        return dp[n];
    }

    static int Space_Optimised(int n) {
        if (n == 0 || n == 1)
            return n;
        if (n == 2)
            return 1;
        int curr = 0;
        int prev = 1;
        int prev1 = 1;
        int prev2 = 0;
        for (int i = 3; i <= n; i++) {
            curr = prev + prev1 + prev2;
            prev2 = prev1;
            prev1 = prev;
            prev = curr;
        }
        return curr;
    }
}