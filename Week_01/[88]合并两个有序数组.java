//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    // 第一遍：

    // 【想法】双指针和两数组元素交换，倒叙
    // 【时间复杂度】O(m+n)
    // 【空间复杂度】O(1)

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int nums1P = m - 1;
        int nums2P = n - 1;
        int curIndex = m + n - 1;
        while (nums1P >= 0 && nums2P >= 0) {
            nums1[curIndex--] = nums1[nums1P] < nums2[nums2P] ? nums2[nums2P--] : nums1[nums1P--];
        }
        System.arraycopy(nums2, 0, nums1, 0, nums2P + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
