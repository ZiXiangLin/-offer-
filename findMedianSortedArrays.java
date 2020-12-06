class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        // 统一奇数和偶数两种情况下的中值
        int mid1 = (m + n + 1) / 2;
        int mid2 = (m + n + 2) / 2;
        return (findKth(nums1,0,m-1,nums2,0,n-1,mid1) + findKth(nums1,0,m-1,nums2,0,n-1,mid2))/2;
    }
    public double findKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        // start1-end1 可选择范围

        // 计算num1/2长度 k/2 步长不超过长度
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        // 两个终止条件： 1）一个数组被全排除、 2）k迭代到1
        // 保证len1是短的那个数组，会被消耗掉
        if(len1 > len2) return findKth(nums2,start2,end2,nums1,start1,end1,k);
        // 如果len1已经被削掉了，相对于现在要求nums2中 第1小->返回start2
        if(len1 == 0) return nums2[start2 + k - 1];
        // 如果k迭代到1，取较小值
        if(k == 1) return Math.min(nums1[start1], nums2[start2]);

        // 比较nums1[i], nums2[j] 排除较小值的那一半，kth不在其中
        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if(nums1[i] <= nums2[j]){
            // 排除nums1中 nums1[start1] 到 nums1[i] [0]->[3] 共减去 3-0+1=4 个数字
            return findKth(nums1,i+1,end1,nums2,start2,end2,k-(i-start1+1));
        }else{
            // 排除nums2中 nums2[start2] 到 nums2[j]
            return findKth(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
        }
    }
}