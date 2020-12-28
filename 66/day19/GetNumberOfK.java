public class Solution {
    public int GetNumberOfK(int [] array , int k) {
        if(array.length == 0) return 0;
        int index = binarySearch(array, 0, array.length - 1, k);
        if(index == -1) return 0;
        int count = 0;
        int curL = index;
        while(curL >= 0 && array[curL] == array[index]) {
            curL--;
            count++;
        }
        int curR = index + 1;
        while(curR < array.length && array[curR] == array[index]) {
            curR++;
            count++;
        }
        return count;
    }
    public int binarySearch(int[] array, int left, int right, int k) {
        if(left > right) return -1; 
        int middle = (left + right) >> 1;
        if(array[middle] == k) return middle;
        else if(array[middle] < k) return binarySearch(array, middle + 1, right, k);
        else return binarySearch(array, left, middle - 1, k);
        
    }
}