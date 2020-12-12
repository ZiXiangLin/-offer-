import java.util.Stack;

public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    int num = 0;

    public void push(int node) {
        stack1.push(node);
        num ++;
    }

    public int pop() {
        // 先从stack1 吐到 stack2 留最后一个pop
        for(int i = 1; i < num; i++) {
            int value = stack1.pop();
            stack2.push(value);
        }
        int pop_value = stack1.pop();
        // 从stack2 吐回 stack1
        for(int i = 1; i < num; i++) {
            int value = stack2.pop();
            stack1.push(value);
        }
        stack2.clear();
        num --;
        return pop_value;
    }
}