class Solution {
    public String longestPalindrome(String s) {t
        if(s.length() == 0) return "";

        // 除非新出现的字符和上一个组成回文，不然不会增加
        // dp[i][j] i到J是否为回文串 i <= j
        // 状态转移： dp[i][j] = s.charAt(i) == j && dp[i+1][j-1]。 中间向两侧推广
        // 对于dp[i][j] 需要 dp[i+1][j-1]  i从大到小-- j从小到大++
        // 初值： dp[i][j] = true;
        // 边界条件：i,j:0-length;
        int length = s.length();
        boolean[][] dp = new boolean[length][length];
        // 初始化dp 长度为1，2，3时可以直接确定是否为回文串
        for(int i = 0; i < length; i++) {
            dp[i][i] = true;

            if(i < length - 1) {
                if (s.charAt(i) == s.charAt(i+1)) dp[i][i+1] = true;
                else dp[i][i+1] = false;
            }

            if(i < length - 2) {
                if(s.charAt(i) == s.charAt(i+2)) dp[i][i+2] = true;
                else dp[i][i+2] = false;
            }
        }
        for(int i = length - 2; i >= 0; i--) {
            for(int j = i + 1; j < length; j++) {
                // 长度小于3，不需要修改dp
                if(j - i < 2) continue;
                // 状态转移方程
                dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i+1][j-1];
            }
        }

        // 查找dp中最长的
        int max = 0;
        int record_x = 0;
        int record_y = 0;
        for(int i = 0; i < length; i++) {
            for(int j = i; j < length; j++) {
                if(dp[i][j] && j - i > max) {
                    max = j - i;
                    record_x = i;
                    record_y = j;
                }
            }
        }


        return s.substring(record_x,record_y + 1);

    }
}