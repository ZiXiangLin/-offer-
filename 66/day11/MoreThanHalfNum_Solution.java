import java.util.*;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0) return 0;
        if(array.length == 1) return array[0];
        Arrays.sort(array);
        int num = 1;
        for(int i = 1; i < array.length; i++) {
            num = array[i] == array[i - 1] ? num + 1 : 1;
            if(num * 2 > array.length) return array[i];
        }
        return 0;
    }
}