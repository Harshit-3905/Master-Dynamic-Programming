import java.util.*;

class House_Robber {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int house[] = new int[n];
        for (int i = 0; i < n; i++)
            house[i] = in.nextInt();
        // int ans = Recursion(house, 0);
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        // int ans = Memoization(house, 0, dp);
        // int ans = Tabulation(house);
        int ans = Space_Optimised(house);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int[] house, int i) {
        if (i >= house.length)
            return 0;
        return Math.max(house[i] + Recursion(house, i + 2), Recursion(house, i + 1));
    }

    static int Memoization(int[] house, int i, int[] dp) {
        if (i >= house.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        dp[i] = Math.max(house[i] + Memoization(house, i + 2, dp), Memoization(house, i + 1, dp));
        return dp[i];
    }

    static int Tabulation(int[] house) {
        int n = house.length;
        if (n == 1)
            return house[0];
        int dp[] = new int[n];
        dp[0] = house[0];
        dp[1] = Math.max(house[0], house[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(house[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }

    static int Space_Optimised(int[] house) {
        int n = house.length;
        if (n == 1)
            return house[0];
        int dp[] = new int[n];
        int curr = 0;
        int prev1 = house[0];
        int prev = Math.max(house[0], house[1]);
        for (int i = 2; i < n; i++) {
            curr = Math.max(house[i] + prev1, prev);
            prev1 = prev;
            prev = curr;
        }
        return prev;
    }
}