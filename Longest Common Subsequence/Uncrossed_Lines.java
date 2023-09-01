import java.util.*;

class Uncrossed_Lines {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int A[] = new int[m];
        int B[] = new int[n];
        for (int i = 0; i < m; i++)
            A[i] = in.nextInt();
        for (int i = 0; i < n; i++)
            B[i] = in.nextInt();
        // int ans = Recursion(A, B, m, n);
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            Arrays.fill(dp[i], -1);
        // int ans = Memoization(A, B, 0, 0, dp);
        // int ans = Tabulation(A, B);
        int ans = Space_Optimised(A, B);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int A[], int B[], int a, int b) {
        if (a == A.length || b == B.length)
            return 0;
        if (A[a] == B[b])
            return 1 + Recursion(A, B, a + 1, b + 1);
        else
            return Math.max(Recursion(A, B, a + 1, b), Recursion(A, B, a, b + 1));
    }

    static int Memoization(int A[], int B[], int a, int b, int dp[][]) {
        if (a == A.length || b == B.length)
            return 0;
        if (dp[a][b] != -1)
            return dp[a][b];
        if (A[a] == B[b])
            dp[a][b] = 1 + Memoization(A, B, a + 1, b + 1, dp);
        else
            dp[a][b] = Math.max(Memoization(A, B, a + 1, b, dp), Memoization(A, B, a, b + 1, dp));
        return dp[a][b];
    }

    static int Tabulation(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1])
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }

    static int Space_Optimised(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int prev[] = new int[n + 1];
        int curr[] = new int[n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1])
                    curr[j] = 1 + prev[j - 1];
                else
                    curr[j] = Math.max(prev[j], curr[j - 1]);
            }
            prev = curr.clone();
        }
        return prev[n];
    }
}