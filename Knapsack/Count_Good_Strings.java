import java.util.*;

class Count_Good_Strings {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int low = in.nextInt();
        int high = in.nextInt();
        int zero = in.nextInt();
        int one = in.nextInt();
        // int ans = Recursion(low, high, zero, one);
        int dp[][] = new int[low + 1][high + 1];
        for (int a[] : dp)
            Arrays.fill(a, -1);
        int ans = Memoization(low, high, zero, one, dp);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int low, int high, int zero, int one) {
        if (high < 0)
            return 0;
        if (low <= 0) {
            return 1 + Recursion(low - zero, high - zero, zero, one) + Recursion(low - one, high - one, zero, one);
        }
        return Recursion(low - zero, high - zero, zero, one) + Recursion(low - one, high - one, zero, one);
    }

    static int Memoization(int low, int high, int zero, int one, int dp[][]) {
        if (high < 0)
            return 0;
        if (low <= 0) {
            return 1 + Memoization(low - zero, high - zero, zero, one, dp)
                    + Memoization(low - one, high - one, zero, one, dp);
        }
        if (dp[low][high] != -1)
            return dp[low][high];
        return dp[low][high] = Memoization(low - zero, high - zero, zero, one, dp)
                + Memoization(low - one, high - one, zero, one, dp);
    }
}