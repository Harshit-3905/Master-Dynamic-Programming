import java.util.*;

class Word_Break {

    boolean Recursion(String s, int i, int x, HashSet<String> set) {
        if (i == s.length()) {
            if (x == i || set.contains(s.substring(x, i)))
                return true;
            else
                return false;
        }
        System.out.println(s.substring(x, i + 1));
        if (set.contains(s.substring(x, i + 1)))
            return Recursion(s, i + 1, x, set) | Recursion(s, i + 1, i + 1, set);
        else
            return Recursion(s, i + 1, x, set);
    }

    int Memoization(String s, int i, int x, HashSet<String> set, int dp[][]) {
        if (i == s.length()) {
            if (x == i || set.contains(s.substring(x, i)))
                return 1;
            else
                return 0;
        }
        if (dp[i][x] != -1)
            return dp[i][x];
        if (set.contains(s.substring(x, i + 1)))
            return dp[i][x] = (Memoization(s, i + 1, x, set, dp) | Memoization(s, i + 1, i + 1, set, dp));
        else
            return dp[i][x] = Memoization(s, i + 1, x, set, dp);
    }

    boolean Tabulation(String s, Set<String> dict) {
        if (s == null || s.length() == 0)
            return false;
        int n = s.length();
        boolean[] dp = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, i + 1);
                if (dict.contains(sub) && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n - 1];
    }
}