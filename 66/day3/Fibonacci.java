public class Solution {
    public int Fibonacci(int n) {
        //dp[n] = dp[n-1] + dp[n-2] 由小推到大 i++
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}