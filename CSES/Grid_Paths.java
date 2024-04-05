import java.io.*;
import java.util.*;

public class Grid_Paths {
    public static void main(String[] args) throws java.lang.Exception {
        FastReader in = new FastReader();
        int n = in.nextInt();
        char grid[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = in.next().toCharArray();
        }
        long dp[][] = new long[n][n];
        dp[0][0] = grid[0][0] == '.' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (grid[i][0] == '.')
                dp[i][0] = dp[i - 1][0];
            if (grid[0][i] == '.')
                dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == '.')
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }
        System.out.println(dp[n - 1][n - 1]);
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