
class Solving_Questions_with_Brainpower {

    static long Recursion(int[][] q, int i) {
        if (i >= q.length)
            return 0;
        long take = q[i][0] + Recursion(q, i + q[i][1] + 1);
        long nottake = Recursion(q, i + 1);
        return Math.max(take, nottake);
    }

    long Memoization(int q[][], int i, long dp[]) {
        if (i >= q.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        long take = q[i][0] + Memoization(q, i + q[i][1] + 1, dp);
        long nottake = Memoization(q, i + 1, dp);
        dp[i] = Math.max(take, nottake);
        return dp[i];
    }

    long Tabulation(int[][] q) {
        int n = q.length;
        long dp[] = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            long take = q[i][0];
            long nottake = dp[i + 1];
            if (i + q[i][1] + 1 < n)
                take += dp[i + q[i][1] + 1];
            dp[i] = Math.max(take, nottake);
        }
        return dp[0];
    }
}