class Solution {
    public int candy(int[] ratings) {
        if(ratings.length == 0) return 0;

        int n = ratings.length;
        // left2right  for index=i, consider left side whether > current
        int[] left2right = new int[n];
        int[] right2left = new int[n];

        left2right[0] = 1;
        for (int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i - 1]) {
                left2right[i] = left2right[i-1] + 1;
            }else left2right[i] = 1;
        }

        right2left[n-1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                right2left[i] = right2left[i+1] + 1;
            }else right2left[i] = 1;
        }

        int ans = 0;
        for(int i = 0; i < n; i++) {
            ans += Math.max(left2right[i], right2left[i]);
        }
        return ans;
    }
}