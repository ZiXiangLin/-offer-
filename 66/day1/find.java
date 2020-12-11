public class Solution {
    public boolean Find(int target, int [][] array) {
        // 小于目标  往上/左
        // 大于目标  往下/右
        // 只往上/右走也能遍历数组 以左下角为起始点 L型
        int width = array[0].length;
        int height = array.length;
        int cur_vertical = height - 1;
        int cur_horizontal = 0;
        while(cur_vertical >= 0 && cur_horizontal < width) {
            if(array[cur_vertical][cur_horizontal] == target) return true;

            if(array[cur_vertical][cur_horizontal] < target) cur_horizontal++;
            else cur_vertical--;
        }
        return false;
    }
}