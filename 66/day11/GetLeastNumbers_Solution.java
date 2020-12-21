import java.util.*;
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        int length = input.length;
        if(k > length || k == 0) return ans;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for(int i = 0; i < length; i++) {
            if(maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if(maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for(Integer integer : maxHeap) {
            ans.add(integer);
        }
        return ans;
        
           
    }
}