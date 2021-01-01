import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array.length == 0) return list;
        int plow = 0, phigh = 1;
        while(plow < phigh && phigh < array.length){
            if(array[plow] + array[phigh] == sum) {
                int temp1 = list.isEmpty() ? 0 : list.get(0);
                int temp2 = list.isEmpty() ? 0 : list.get(1);
                int mult = temp1 * temp2;
                if(mult == 0 || mult > array[plow] * array[phigh]) {
                    list.clear();
                    list.add(array[plow]);
                    list.add(array[phigh]);
                }else plow++;
            }
            else if(array[plow] + array[phigh] < sum) phigh++;
            else if(array[plow] + array[phigh] > sum) {
                plow++;
                phigh = plow + 1;
            }
        }
        return list;
    }
}