import java.util.*;

class Triangle {

    static int Tabulation(List<List<Integer>> triangle) {
        int n = triangle.size();
        int dp[][] = new int[n][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == i)
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
                else if (j > 0)
                    dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j - 1], dp[i - 1][j]);
                else
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++)
            ans = Math.min(ans, dp[n - 1][j]);
        return ans;
    }

    static int Space_Optimised(List<List<Integer>> triangle) {
        int n = triangle.size();
        int prev[] = new int[n];
        int curr[] = new int[n];
        prev[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == i)
                    curr[j] = triangle.get(i).get(j) + prev[j - 1];
                else if (j > 0)
                    curr[j] = triangle.get(i).get(j) + Math.min(prev[j - 1], prev[j]);
                else
                    curr[j] = triangle.get(i).get(j) + prev[j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++)
            ans = Math.min(ans, dp[n - 1][j]);
        return ans;
    }
}