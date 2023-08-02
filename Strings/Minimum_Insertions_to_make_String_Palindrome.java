
class Minimum_Insertions_to_make_String_Palindrome {

    static int Tabulation(String s) {
        StringBuilder st = new StringBuilder(s);
        String t = st.reverse().toString();
        int n = s.length();
        int dp[][] = new int[n + 1][n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return n - ans;
    }

    static int Space_Optimised(String s) {
        StringBuilder st = new StringBuilder(s);
        String t = st.reverse().toString();
        int n = s.length();
        int prev[] = new int[n + 1];
        int curr[] = new int[n + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1))
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                ans = Math.max(ans, curr[j]);
            }
            prev = curr.clone();
        }
        return n - ans;
    }
}