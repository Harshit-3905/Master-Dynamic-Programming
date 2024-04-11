import java.io.*;
import java.util.*;

public class Array_Description {
    public static void main(String[] args) throws java.lang.Exception {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int m = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        long dp[][] = new long[n][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = (int) Recursion(0, arr, m, 0, dp);
        System.out.println(ans);
    }

    static long Recursion(int i, int arr[], int m, int prev, long dp[][]) {
        if (i == arr.length) {
            return 1;
        }
        if (dp[i][prev] != -1)
            return dp[i][prev];
        long ans = 0;
        if (arr[i] == 0) {
            if (prev == 0) {
                for (int j = 1; j <= m; j++) {
                    ans = (ans + Recursion(i + 1, arr, m, j, dp)) % 1000000007;
                }
            } else {
                if (prev - 1 >= 1)
                    ans = (ans + Recursion(i + 1, arr, m, prev - 1, dp)) % 1000000007;
                ans = (ans + Recursion(i + 1, arr, m, prev, dp)) % 1000000007;
                if (prev + 1 <= m)
                    ans = (ans + Recursion(i + 1, arr, m, prev + 1, dp)) % 1000000007;
            }
        } else {
            if (prev == 0) {
                return Recursion(i + 1, arr, m, arr[i], dp);
            } else {
                if (Math.abs(prev - arr[i]) <= 1) {
                    return Recursion(i + 1, arr, m, arr[i], dp);
                } else {
                    return 0;
                }
            }
        }
        return dp[i][prev] = ans;
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    float nextFloat() {
        return Float.parseFloat(next());
    }

    boolean nextBoolean() {
        return Boolean.parseBoolean(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}