class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        // 记录左侧和右侧的最大值
        // max_right  包括自己在内的情况下 右侧最高的柱子
        int length = height.length;
        int[] max_right = new int[length];
        max_right[length - 1] = height[length - 1];
        for(int j = length - 2; j >= 0; j--) {
            max_right[j] = Math.max(max_right[j+1], height[j]);
        }

        int[] max_left = new int[length];
        max_left[0] = height[0];
        for(int j = 1; j < length; j++) {
            max_left[j] = Math.max(max_left[j-1], height[j]);
        }

        int ans = 0;
        for(int i = 0; i < length; i++) {
            ans += Math.min(max_left[i], max_right[i]) - height[i];
        }

        return ans;
    }
}