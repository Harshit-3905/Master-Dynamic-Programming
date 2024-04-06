import java.io.*;
import java.util.*;

public class Book_Shop {
    public static void main(String[] args) throws java.lang.Exception {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int x = in.nextInt();
        int[] price = new int[n];
        int[] pages = new int[n];

        for (int i = 0; i < n; i++) {
            price[i] = in.nextInt();
        }

        for (int i = 0; i < n; i++) {
            pages[i] = in.nextInt();
        }

        int[][] dp = new int[n + 1][x + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= x; j++) {
                dp[i][j] = dp[i - 1][j];
                int left = j - price[i - 1];
                if (left >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][left] + pages[i - 1]);
                }
            }
        }

        System.out.println(dp[n][x]);
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