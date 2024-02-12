import java.util.*;

class Delete_and_Earn {
    public int deleteAndEarn(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        int a[][] = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            a[index][0] = x.getKey();
            a[index][1] = x.getValue();
            index++;
        }
        int dp[] = new int[index];
        dp[0] = a[0][0] * a[0][1];
        if (index == 1)
            return dp[0];
        if (a[1][0] - a[0][0] == 1)
            dp[1] = Math.max(dp[0], a[1][0] * a[1][1]);
        else
            dp[1] = dp[0] + a[1][0] * a[1][1];
        for (int i = 2; i < index; i++) {
            if (a[i][0] - a[i - 1][0] == 1)
                dp[i] = Math.max(dp[i - 1], a[i][0] * a[i][1] + dp[i - 2]);
            else
                dp[i] = dp[i - 1] + a[i][0] * a[i][1];
        }
        return dp[index - 1];
    }
}