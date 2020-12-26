public class Solution {
    int cnt, CONST = 1000000007;
    public int InversePairs(int [] array) {
        if(array.length == 0) return 0;
        int[] B = new int[array.length];
        mergeSort(array, B, 0, array.length - 1);
        return cnt;
    }
    void mergeSort(int[] A, int[] B, int left, int right) {
        if(left >= right) return;
        int middle = (left + right) >> 1;
        mergeSort(A, B, left, middle);
        mergeSort(A, B, middle + 1, right);
        merge(A, B, left, middle, right);
    }
    void merge(int[] A, int[] B, int left, int middle, int right) {
        int curL = left, curM = middle + 1, curB = left;
        while(curL <= middle && curM <= right) {
            if(A[curL] > A[curM]) {
                // curL - middle 范围内都 > A[curM]
                cnt = (cnt + (middle - curL + 1) % CONST) % CONST;
                B[curB++] = A[curM++];
            }else {
                B[curB++] = A[curL++];
            }
        }
        while(curL <= middle) {
            B[curB++] = A[curL++];
        }
        while(curM <= right) {
            B[curB++] = A[curM++];
        }
        // copy B 2 A
        for(int i = left; i <= right; i++) {
            A[i] = B[i];
        }
    }
}