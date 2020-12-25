import java.util.*;

public class Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index == 0) return 0;
        int minVal = 0;
        Queue<Integer> q2 = new LinkedList<>();
        Queue<Integer> q3 = new LinkedList<>();
        Queue<Integer> q5 = new LinkedList<>();
        q2.offer(1);
        for(int i = 0; i < index; i++) {
            int val2 = q2.isEmpty() ? Integer.MAX_VALUE : q2.peek();
            int val3 = q3.isEmpty() ? Integer.MAX_VALUE : q3.peek();
            int val5 = q5.isEmpty() ? Integer.MAX_VALUE : q5.peek();
            minVal = Math.min(val2, Math.min(val3, val5));
            if(minVal == val2) {
                q2.poll();
                q2.offer( 2 * minVal);
                q3.offer( 3 * minVal);
            }
            else if(minVal == val3) {
                q3.poll();
                q3.offer( 3 * minVal);
            }
            else if(minVal == val5) {
                q5.poll();
            }
            q5.offer( 5 * minVal);
        }
        return minVal;
    }
}