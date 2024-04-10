import java.io.*;
import java.util.*;

public class Money_Sums {
    public static void main(String[] args) throws java.lang.Exception {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int max_sum = n * 1000;
        boolean[][] dp = new boolean[n + 1][max_sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= max_sum; j++) {
                dp[i][j] = dp[i - 1][j];
                int left = j - arr[i - 1];
                if (left >= 0 && dp[i - 1][left]) {
                    dp[i][j] = true;
                }
            }
        }
        List<Integer> possible = new ArrayList<>();
        for (int j = 1; j <= max_sum; j++) {
            if (dp[n][j]) {
                possible.add(j);
            }
        }

        System.out.println(possible.size());
        for (int v : possible) {
            System.out.print(v + " ");
        }
        System.out.println();
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