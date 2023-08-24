import java.util.*;

class Perfect_Squares {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        // int ans = Recursion(n);
        // int dp[] = new int[n + 1];
        // Arrays.fill(dp, -1);
        // int ans = Memoization(n, dp);
        int ans = Tabulation(n);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int n) {
        if (n == 0 || n == 1)
            return n;
        int x = (int) Math.sqrt(n);
        int ans = 1000000;
        for (int i = x; i >= 1; i--) {
            ans = Math.min(ans, 1 + Recursion(n - (i * i)));
        }
        return ans;
    }

    static int Memoization(int n, int dp[]) {
        if (n == 0 || n == 1)
            return n;
        if (dp[n] != -1)
            return dp[n];
        int x = (int) Math.sqrt(n);
        int ans = 1000000;
        for (int i = x; i >= 1; i--) {
            ans = Math.min(ans, 1 + Memoization(n - (i * i), dp));
        }
        return dp[n] = ans;
    }

    static int Tabulation(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, 1000000);
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int x = (int) Math.sqrt(i);
            for (int j = x; j >= 1; j--) {
                dp[i] = Math.min(1 + dp[i - (j * j)], dp[i]);
            }
        }
        return dp[n];
    }
}