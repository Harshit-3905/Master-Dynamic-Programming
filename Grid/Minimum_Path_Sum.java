import java.util.*;

class Minimum_Path_Sum {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int grid[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        // int ans = Recursion(m - 1, n - 1, grid);
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], -1);
        // int ans = Memoization(m - 1, n - 1, grid, dp);
        // int ans = Tabulation(m, n, grid);
        int ans = Space_Optimised(m, n, grid);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int m, int n, int[][] grid) {
        if (m == 0 && n == 0)
            return grid[0][0];
        int left = Integer.MAX_VALUE;
        int top = Integer.MAX_VALUE;
        if (m > 0)
            left = Recursion(m - 1, n, grid);
        if (n > 0)
            top = Recursion(m, n - 1, grid);
        return grid[m][n] + Math.min(left, top);
    }

    static int Memoization(int m, int n, int[][] grid, int[][] dp) {
        if (m == 0 && n == 0)
            return grid[0][0];
        int left = Integer.MAX_VALUE;
        int top = Integer.MAX_VALUE;
        if (dp[m][n] != -1)
            return dp[m][n];
        if (m > 0)
            left = Memoization(m - 1, n, grid, dp);
        if (n > 0)
            top = Memoization(m, n - 1, grid, dp);
        dp[m][n] = grid[m][n] + Math.min(left, top);
        return dp[m][n];
    }

    static int Tabulation(int m, int n, int[][] grid) {
        if (m == 0 && n == 0)
            return grid[0][0];
        int dp[][] = new int[m][n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grid[0][i];
            dp[0][i] = sum;
        }
        sum = 0;
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            dp[i][0] = sum;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    static int Space_Optimised(int m, int n, int[][] grid) {
        if (m == 0 && n == 0)
            return grid[0][0];
        int dp[] = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grid[0][i];
            dp[i] = sum;
        }
        sum = grid[0][0];
        for (int i = 1; i < m; i++) {
            sum += grid[i][0];
            dp[0] = sum;
            for (int j = 1; j < n; j++) {
                dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
            }
        }
        return dp[n - 1];
    }
}