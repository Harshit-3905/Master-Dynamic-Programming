
class Minimum_Falling_Path_Sum {
    public int Tabulation(int[][] matrix) {
        int n = matrix.length;
        int dp[][] = new int[n][n];
        for (int j = 0; j < n; j++)
            dp[0][j] = matrix[0][j];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                else if (j == n - 1)
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                else
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
                dp[i][j] += matrix[i][j];
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++)
            ans = Math.min(ans, dp[n - 1][j]);
        return ans;
    }

    public int Space_Optimised(int[][] matrix) {
        int n = matrix.length;
        int prev[] = new int[n];
        int curr[] = new int[n];
        for (int j = 0; j < n; j++)
            prev[j] = matrix[0][j];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    curr[j] = Math.min(prev[j], prev[j + 1]);
                else if (j == n - 1)
                    curr[j] = Math.min(prev[j], prev[j - 1]);
                else
                    curr[j] = Math.min(prev[j], Math.min(prev[j - 1], prev[j + 1]));
                curr[j] += matrix[i][j];
            }
            prev = curr.clone();
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++)
            ans = Math.min(ans, prev[j]);
        return ans;
    }
}