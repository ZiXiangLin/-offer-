public class Solution {
    public int JumpFloorII(int target) {
        // 到n级时 可能是跳1/跳2/ ...跳n次上来的
        // ans[n] = ans[n-1] + ans[n-2] + ... + ans[0];
        // ans[n+1] = ans[n] + (ans[n-1] + ... + ans[0]) = 2*ans[n-1];
        if(target == 0) return 0;
        if(target == 1) return 1;
        int[] ans = new int[target];
        ans[0] = 1;
        for(int i = 1; i < target; i++) {
            ans[i] = 2 * ans[i-1];
        }
        return ans[target - 1];
    }
}