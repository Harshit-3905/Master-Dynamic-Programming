import java.util.*;

class Decode_Ways {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        // int ans = Recursion(0, s);
        // int dp[] = new int[s.length()];
        // Arrays.fill(dp, -1);
        // int ans = Memoization(0, s, dp);
        // int ans = Tabulation(s);
        int ans = SpaceOptimized(s);
        System.out.println(ans);
        in.close();
    }

    public static int Recursion(int i, String s) {
        if (i == s.length())
            return 1;
        int take = 0;
        int nottake = 0;
        if (s.charAt(i) != '0') {
            nottake = Recursion(i + 1, s);
            if (i != s.length() - 1 && ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0')) <= 26)
                take = Recursion(i + 2, s);
        }
        return take + nottake;
    }

    public static int Memoization(int i, String s, int dp[]) {
        if (i == s.length())
            return 1;
        if (dp[i] != -1)
            return dp[i];
        int take = 0;
        int nottake = 0;
        if (s.charAt(i) != '0') {
            nottake = Memoization(i + 1, s, dp);
            if (i != s.length() - 1 && ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0')) <= 26)
                take = Memoization(i + 2, s, dp);
        }
        return dp[i] = take + nottake;
    }

    public static int Tabulation(String s) {
        int n = s.length();
        int dp[] = new int[n + 1];
        dp[s.length()] = 1;
        for (int i = n - 1; i >= 0; i--) {
            int take = 0;
            int nottake = 0;
            if (s.charAt(i) != '0') {
                nottake = dp[i + 1];
                if (i != n - 1 && ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0')) <= 26)
                    take = dp[i + 2];
            }
            dp[i] = take + nottake;
        }
        return dp[0];
    }

    public static int SpaceOptimized(String s) {
        int dp1 = 1, dp2 = 0, n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            int dp = s.charAt(i) == '0' ? 0 : dp1;
            if (i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
                dp += dp2;
            dp2 = dp1;
            dp1 = dp;
        }
        return dp1;
    }
}