public class Solution {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return helper(sequence, 0, sequence.length - 1);
    }
    public boolean helper(int[] sequence, int start, int root) {
        // 判断 start -> root 范围内是否合理
        if(start >= root) return true;
        int cur = start;
        // left tree (val < root)
        for(; cur < root; cur++) {
            if(sequence[cur] > sequence[root]) break;
        }
        // right tree (val > root)
        int tick = cur - 1;
        for(; cur < root; cur++) {
            if(sequence[cur] < sequence[root]) return false;
        }
        return helper(sequence, start, tick) && helper(sequence, tick + 1, root - 1);
    }
}