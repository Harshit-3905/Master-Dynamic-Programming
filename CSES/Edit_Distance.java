import java.io.*;
import java.util.*;

public class Edit_Distance {
    public static void main(String[] args) throws java.lang.Exception {
        FastReader in = new FastReader();
        String s1 = in.next();
        String s2 = in.next();
        int m = s1.length();
        int n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        for (int j = 0; j < n; j++)
            dp[m][j] = n - j;
        for (int i = 0; i < m; i++)
            dp[i][n] = m - i;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    dp[i][j] = dp[i + 1][j + 1];
                else {
                    int insert = 1 + dp[i][j + 1];
                    int delete = 1 + dp[i + 1][j];
                    int replace = 1 + dp[i + 1][j + 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        int ans = dp[0][0];
        System.out.println(ans);
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