import java.util.*;

public class Solution {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length == 0) return false;
        Arrays.sort(numbers);
        int count = 0;
        for(int i = 0; i < 5; i++) {
            if(numbers[i] == 0) count++;
            else break;
        }
        for(int i = 0; i < 4; i++) {
            if(numbers[i] == numbers[i+1] && numbers[i] != 0) return false;
        }
        int cur = 4;
        while(cur >= 1) {
            int temp = numbers[cur] - 1;
            if(temp == numbers[cur - 1]) cur--;
            else {
               if(count > 0) {
                   numbers[0] = temp;
                   Arrays.sort(numbers);
                   cur--;
                   count--;
               }else return false;
            }
        }
        return true;
    }
}