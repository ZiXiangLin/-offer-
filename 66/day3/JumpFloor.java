public class Solution {
    public int JumpFloor(int target) {
        // 到当前台阶有两种可能：跳1上来+跳2上来
        // dp[n-1]: 跳到n级台阶有几种跳法，则
        // dp[0] = 1; dp[1] = 2
        // dp[n] = dp[n-1] + dp[n-2]
        if(target == 0) return 0;
        if(target == 1) return 1;
        if(target == 2) return 2;
        int[] dp = new int[target];
        dp[0] = 1;
        dp[1] = 2;
        for(int i = 2; i < target; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[target - 1];
    }
}