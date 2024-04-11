import java.io.*;
import java.util.*;

public class Removal_Game {
    public static void main(String[] args) throws java.lang.Exception {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int arr[] = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }
        long[][] dp = new long[n][n];

        for (int l = n - 1; l >= 0; l--) {
            for (int r = l; r < n; r++) {
                if (l == r) {
                    dp[l][r] = arr[l];
                } else {
                    dp[l][r] = Math.max(arr[l] - dp[l + 1][r], arr[r] - dp[l][r - 1]);
                }
            }
        }

        System.out.println((sum + dp[0][n - 1]) / 2);
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