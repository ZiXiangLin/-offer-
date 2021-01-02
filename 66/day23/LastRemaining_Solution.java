import java.util.*;

public class Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(m == 0 || n == 0) return -1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(i);
        }
        int temp = -1;
        while(list.size() > 1) {
            temp = (temp + m) % list.size();
            list.remove(temp);
            temp --;
        }
        return list.get(0);
    }
}