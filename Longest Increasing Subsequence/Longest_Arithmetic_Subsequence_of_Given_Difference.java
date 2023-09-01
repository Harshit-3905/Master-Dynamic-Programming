import java.util.*;

class Longest_Arithmetic_Subsequence_of_Given_Difference {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int diff = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();
        // int ans = Recursion(arr, diff, 0, 1);
        int dp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        // int ans = Memoization(arr, diff, 0, 1, dp);
        int ans = Space_Optimised(arr, diff);
        System.out.println(ans);
        in.close();
    }

    static int Recursion(int arr[], int diff, int i, int count) {
        if (i == arr.length - 1)
            return count;
        if (arr[i + 1] - arr[i] == diff)
            return Recursion(arr, diff, i + 1, count + 1);
        else
            return Recursion(arr, diff, i + 1, count);
    }

    static int Memoization(int arr[], int diff, int i, int count, int dp[][]) {
        if (i == arr.length - 1)
            return count;
        if (dp[i][count] != -1)
            return dp[i][count];
        if (arr[i + 1] - arr[i] == diff)
            return dp[i][count] = Memoization(arr, diff, i + 1, count + 1, dp);
        else
            return dp[i][count] = Memoization(arr, diff, i + 1, count, dp);
    }

    static int Space_Optimised(int arr[], int diff) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 1;
        for (int x : arr) {
            if (map.containsKey(x - diff)) {
                int y = map.get(x - diff);
                map.put(x, y + 1);
                ans = Math.max(ans, y + 1);
            } else
                map.put(x, 1);
        }
        return ans;
    }
}