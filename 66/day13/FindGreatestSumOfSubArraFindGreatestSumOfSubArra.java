public class Solution {
    public int FindGreatestSumOfSubArray(int[] array) {
        // dp[i] :  the greatest sum of sub array ended with array[i]
        // dp[i+1] = max(0, dp[i]) + array[i+1];
        if(array.length == 0) return 0;
        int[] dp = new int[array.length];
        dp[0] = array[0];
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i < array.length; i++) {
            dp[i] = Math.max(0, dp[i-1]) + array[i];
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}