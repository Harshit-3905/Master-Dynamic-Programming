import java.util.*;

class Minimum_ASCII_Delete_Sum_for_Two_Strings {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        // int ans = Recursion(s1, s2, 0, 0);
        // int m = s1.length();
        // int n = s2.length();
        // int dp[][] = new int[m + 1][n + 1];
        // for (int i = 0; i <= m; i++)
        // Arrays.fill(dp[i], -1);
        // int ans = Memoization(s1, s2, 0, 0, dp);
        // int ans = Tabulation(s1, s2);
        int ans = Space_Optimised(s1, s2);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(String s1, String s2, int i, int j) {
        if (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                return Recursion(s1, s2, i + 1, j + 1);
            } else {
                return Math.min((int) s1.charAt(i) + Recursion(s1, s2, i + 1, j),
                        (int) s2.charAt(j) + Recursion(s1, s2, i, j + 1));
            }
        } else if (i < s1.length()) {
            return (int) s1.charAt(i) + Recursion(s1, s2, i + 1, j);
        } else if (j < s2.length()) {
            return (int) s2.charAt(j) + Recursion(s1, s2, i, j + 1);
        }
        return 0;
    }

    static int Memoization(String s1, String s2, int i, int j, int dp[][]) {
        if (dp[i][j] != -1)
            return dp[i][j];
        if (i < s1.length() && j < s2.length()) {
            if (s1.charAt(i) == s2.charAt(j)) {
                return dp[i][j] = Memoization(s1, s2, i + 1, j + 1, dp);
            } else {
                return dp[i][j] = Math.min((int) s1.charAt(i) + Memoization(s1, s2, i + 1, j, dp),
                        (int) s2.charAt(j) + Memoization(s1, s2, i, j + 1, dp));
            }
        } else if (i < s1.length()) {
            return dp[i][j] = (int) s1.charAt(i) + Memoization(s1, s2, i + 1, j, dp);
        } else if (j < s2.length()) {
            return dp[i][j] = (int) s2.charAt(j) + Memoization(s1, s2, i, j + 1, dp);
        }
        return 0;
    }

    static int Tabulation(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= s1.length(); i++)
            dp[i][0] = dp[i - 1][0] + s1.charAt(i - 1);

        for (int j = 1; j <= s2.length(); j++)
            dp[0][j] = dp[0][j - 1] + s2.charAt(j - 1);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.min(s1.charAt(i - 1) + dp[i - 1][j], s2.charAt(j - 1) + dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    static int Space_Optimised(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int prev[] = new int[n + 1];
        int curr[] = new int[n + 1];
        for (int j = 1; j <= s2.length(); j++)
            prev[j] = prev[j - 1] + s2.charAt(j - 1);
        for (int i = 1; i <= m; i++) {
            curr[0] = prev[0] + s1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    curr[j] = prev[j - 1];
                else
                    curr[j] = Math.min(s1.charAt(i - 1) + prev[j], s2.charAt(j - 1) + curr[j - 1]);
            }
            prev = curr.clone();
        }
        return prev[n];
    }

}