class Solution {
    public int findKthNumber(int n, int k) {
        // 字典排序 -> 理解为十叉树
        // prefix： 当前的前缀 如对于112的11
        // p: 当前找到的第p大的数，找到k就可以结束
        // count： 当前的前缀下，给定整数范围内的数目，如对n=12 prefix=1有 1、10、11、12 ，count=4
        int prefix = 1;
        int p = 1;
        int count = 0;
        while(p < k) {
            count = getAvailableCount(prefix, n);

            // 由于接下来的count数超过了字典序列下的k，可以确定值就在该节点的子树下，需要跳下一层
            if(p + count > k) {
                prefix *= 10;
                p++;  // 往下走一层，只跨过了prefix这个节点，计数加一

                // 跨的步数还不够长，字典序下往前走count数还不够，需要跳到下一个前缀
                // 对于n=k=13的情况，当前的前缀prefix=10 count=1, 对于k=13 需要走到下一个prefix=11
            }else if(p + count <= k) {
                prefix ++ ;
                p += count; // 跨过了字典序下共count个数

            }
        }
        // 到后面收敛走第二种if情况，逐渐++ 且第一种if存在恰好的情况
        return prefix;
    }
    public int getAvailableCount(int prefix, int n) {
        // 对于给定的前缀，寻找n范围下该节点下的总节点数目ans 如对于n=13，prefix=1， 有1，10，11，12，13 共ans=5
        int ans = 0;
        // 两个指针，一个指向当前前缀如10， 一个指向右侧的下一个前缀如11，初始值由传入的prefix确定
        long cur = prefix;
        long next = prefix + 1;
        while(cur <= n) {
            // 防止超出范围，需要控制next前缀不超过n
            ans += Math.min(n+1, next) - cur;
            // 往下走一层，从2-1 到20-10
            cur *= 10;
            next *= 10;
        }
        return ans;
    }
}