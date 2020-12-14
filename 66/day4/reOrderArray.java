import java.util.*;

public class Solution {
    public void reOrderArray(int [] array) {
        Queue<Integer> queue1 = new LinkedList<Integer>();
        Queue<Integer> queue2 = new LinkedList<Integer>();
        for(int i = 0; i < array.length; i++) {
            if(array[i] % 2 == 1) queue1.offer(array[i]);
            else queue2.offer(array[i]);
        }
        for(int j = 0; j < array.length; j++) {
            if(queue1.size() > 0) array[j] = (int)queue1.poll();
            else array[j] = (int) queue2.poll();
        }
    }
}