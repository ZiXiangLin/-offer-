public class Solution {
    public int RectCover(int target) {
        // 对于2*n 可以补一块竖的 也可以补两块横的
        // dp[n] = dp[n-1] + dp[n-2];
        if(target == 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        int[] dp = new int[target + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= target; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target];
    }
}