import java.util.Stack;

public class Solution {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> helper = new Stack<Integer>();
    int min = Integer.MAX_VALUE;
    public void push(int node) {
        stack.push(node);
        if(node < min) min = node;
    }
    
    public void pop() {
        if(stack.pop() == min) {
            min = Integer.MAX_VALUE;
            while(!stack.isEmpty()) {
                int temp = stack.pop();
                min = Math.min(min, temp);
                helper.push(temp);
            }
            while(!helper.isEmpty()) {
                stack.push(helper.pop());
            }
        }
        
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return min;
    }
}