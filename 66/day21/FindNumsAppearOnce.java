//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
import java.util.*;

public class Solution {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int length = array.length;
        if(length == 2) {
            num1[0] = array[0];
            num2[0] = array[1];
            return;
        }
        int bitResult = 0;
        for(int i = 0; i < length; i++) {
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);
        for(int i = 0; i < length; i++) {
            if(IsBit(array[i], index) == 1) {
                num1[0] ^= array[i];
            }else num2[0] ^= array[i];
        }
    }
    public int findFirst1(int bitResult) {
        int index = 0;
        while(((bitResult & 1) == 0) && index < 32) {
            bitResult >>= 1;
            index++;
        }
        return index;
    }
    public int IsBit(int num, int index) {
        num = num >> index;
        return (num & 1);
    }
}