import java.util.*;

class Unique_PathsII {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int grid[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = in.nextInt();
        // int ans = Recursion(m - 1, n - 1, grid);
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        // int ans = Memoization(m - 1, n - 1, dp, grid);
        // int ans = Tabulation(m, n, grid);
        int ans = Space_Optimised(m, n, grid);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int m, int n, int[][] grid) {
        if (grid[m][n] == 1)
            return 0;
        if (m == 0 && n == 0)
            return 1;
        int top = 0;
        int left = 0;
        if (m > 0)
            top = Recursion(m - 1, n, grid);
        if (n > 0)
            left = Recursion(m, n - 1, grid);
        return left + top;
    }

    static int Memoization(int m, int n, int[][] dp, int[][] grid) {
        if (grid[m][n] == 1)
            return 0;
        if (m == 0 && n == 0)
            return 1;
        int top = 0;
        int left = 0;
        if (dp[m][n] != -1)
            return dp[m][n];
        if (m > 0)
            top = Memoization(m - 1, n, dp, grid);
        if (n > 0)
            left = Memoization(m, n - 1, dp, grid);
        dp[m][n] = left + top;
        return dp[m][n];
    }

    static int Tabulation(int m, int n, int grid[][]) {
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
            return 0;
        int dp[][] = new int[m][n];
        for (int i = 0; i < n; i++)
            if (grid[0][i] == 0)
                dp[0][i] = 1;
            else
                break;
        for (int i = 0; i < m; i++)
            if (grid[i][0] == 0)
                dp[i][0] = 1;
            else
                break;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1)
                    dp[i][j] = 0;
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    static int Space_Optimised(int m, int n, int[][] grid) {
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
            return 0;
        int dp[] = new int[n];
        for (int i = 0; i < n; i++)
            if (grid[0][i] == 0)
                dp[i] = 1;
            else
                break;
        for (int i = 1; i < m; i++) {
            if (grid[i][0] == 1)
                dp[0] = 0;
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1)
                    dp[j] = 0;
                else
                    dp[j] = dp[j] + dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}