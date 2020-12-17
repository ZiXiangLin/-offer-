import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int cur = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < popA.length; i++) {
            // not match
            if(stack.isEmpty()) stack.push(pushA[cur++]);
            while(stack.peek()!= popA[i]) {
               if(cur >= pushA.length) return false;
               else stack.push(pushA[cur++]);
            }
            // match
            if(stack.peek() == popA[i]) stack.pop();
            
        }
        return true;
    }
}