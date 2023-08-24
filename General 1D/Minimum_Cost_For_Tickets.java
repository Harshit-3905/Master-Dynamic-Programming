class Minimum_Cost_For_Tickets {

    static int Recursion(int[] days, int[] costs, int i, int day) {
        if (i == days.length)
            return 0;
        if (days[i] >= day) {
            return Math.min(costs[0] + Recursion(days, costs, i + 1, days[i] + 1),
                    Math.min(costs[1] + Recursion(days, costs, i + 1, days[i] + 7),
                            costs[2] + Recursion(days, costs, i + 1, days[i] + 30)));
        }
        return Recursion(days, costs, i + 1, day);
    }

    static int Memoization(int[] days, int[] costs, int i, int day, int dp[][]) {
        if (day > 365)
            return 0;
        if (i == days.length)
            return 0;
        if (dp[i][day] != -1)
            return dp[i][day];
        if (days[i] >= day) {
            return dp[i][day] = Math.min(costs[0] + Memoization(days, costs, i + 1, days[i] + 1, dp),
                    Math.min(costs[1] + Memoization(days, costs, i + 1, days[i] + 7, dp),
                            costs[2] + Memoization(days, costs, i + 1, days[i] + 30, dp)));
        }
        return dp[i][day] = Memoization(days, costs, i + 1, day, dp);
    }

    static int Tabulation(int[] days, int[] costs) {
        int[] dp = new int[366];
        for (int i = 0; i < days.length; i++) {
            dp[days[i]] = 1;
        }
        for (int i = 1; i <= days[days.length - 1]; i++) {
            if (dp[i] == 0) {
                dp[i] = dp[i - 1];
                continue;
            }
            int cur = dp[i - 1] + costs[0];
            cur = Math.min(cur, dp[Math.max(0, i - 7)] + costs[1]);
            cur = Math.min(cur, dp[Math.max(0, i - 30)] + costs[2]);

            dp[i] = cur;
        }
        return dp[days[days.length - 1]];
    }
}