import java.util.*;

public class Solution {
    public String PrintMinNumber(int [] numbers) {
        int length = numbers.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                if(IsFront(o1, o2)) return -1;
                else return 1;
            }
        });
        String ans = "";
        Iterator iter = list.iterator();
        while(iter.hasNext()){
            ans += String.valueOf(iter.next());
        }
        return ans;
    }
    public boolean IsFront(int a, int b) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while(a > 0) {
            int temp = a % 10;
            stack1.push(temp);
            a -= temp;
            a /= 10;
        }
        while(b > 0) {
            int temp = b % 10;
            stack2.push(temp);
            b -= temp;
            b /= 10;
        }
        while( !stack1.isEmpty() && !stack2.isEmpty()) {
            if(stack1.peek() < stack2.peek()) return true;
            if(stack1.peek() > stack2.peek()) return false;
            if(stack1.peek() == stack2.peek()) {
               if(stack1.size() == 1 && stack2.size() == 1) return true;
               if(stack1.size() > 1) stack1.pop();
               if(stack2.size() > 1) stack2.pop();
            }
        }
        return true;
    }
}