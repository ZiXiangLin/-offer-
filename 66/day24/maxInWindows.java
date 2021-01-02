import java.util.*;

public class Solution {
    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        int length = num.length;
        int pace = length - size + 1;
        if(pace <= 0 || size == 0) return list;
        int elem = helper(num, 0, size - 1);
        list.add(elem);
        for(int i = 1; i < pace; i++) {
            int left = i;
            int right = i + size - 1;
            if(num[left - 1] == elem) {
                elem = helper(num, left, right);
            }else {
                elem = Math.max(elem, num[right]);
            }
            list.add(elem);
        }
        return list;
    }
    public int helper(int[]num, int left, int right) {
        int ans = num[left];
        for(int i = left + 1; i <= right; i++) {
            ans = Math.max(ans, num[i]);
        }
        return ans;
    }
}