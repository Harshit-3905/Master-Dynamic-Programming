import java.util.*;

class Buy_and_Sell_Stock {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int prices[] = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }
        int min = prices[0];
        int ans = 0;
        for (int i = 1; i < n; i++) {
            min = Math.min(prices[i], min);
            ans = Math.max(ans, prices[i] - min);
        }
        System.out.println(ans);
        in.close();
    }
}