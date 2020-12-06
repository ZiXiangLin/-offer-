class Solution {
    public void rotate(int[][] matrix) {
        // 先转置 再翻转
        int n = matrix[0].length;
        for(int i = 0; i < n; i++) {
            // 转置 [i] [j] -> [j] [i]
            for(int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i = 0; i < n / 2; i++) {
            for(int j = 0; j < n; j++) {
                // 翻转 [i][j] -> [n-i][j]
                // 0 和 n-1
                int temp = matrix[j][i];
                matrix[j][i] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
}