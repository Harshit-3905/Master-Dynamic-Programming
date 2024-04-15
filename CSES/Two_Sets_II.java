import java.io.*;
import java.util.*;

public class Two_Sets_II {

    public static void main(String[] args) throws java.lang.Exception {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int sum = (n * (n + 1)) / 2;
        if (sum % 2 != 0) {
            System.out.println(0);
        } else {
            sum = sum / 2;
            long dp[][] = new long[n + 1][sum + 1];
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 1l;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= sum; j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= i) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - i]) % 1000000007;
                    }
                }
            }
            System.out.println(dp[n - 1][sum]);
        }
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