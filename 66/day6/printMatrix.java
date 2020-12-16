import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        int up = 0;
        int down = matrix.length - 1;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if(matrix.length == 0 || matrix[0].length == 0) return ans;
        while(up <= down && left <= right) {
            for(int i = left; i <= right; i++) ans.add(matrix[up][i]);
            for(int i = up + 1; i <= down; i++) ans.add(matrix[i][right]);
            if(up != down)
                for(int i = right - 1; i >= left; i--) ans.add(matrix[down][i]);
            if(left != right)
                for(int i = down - 1; i > up; i--) ans.add(matrix[i][left]);
            up++; left++; down--; right--;
        }
        return ans;
    }
}