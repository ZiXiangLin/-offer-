public class Solution {
    public int NumberOf1(int n) {
        // 1100 - 1 = 1011
        // 1100 & 1011 = 1000
        // 每含一个1 便可以如此操作一次
        int ans = 0;
        while(n != 0) {
            ans++;
            n = n & (n-1);
        }
        return ans;
    }
}