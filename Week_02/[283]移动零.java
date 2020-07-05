//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 第一遍：
    // 【想法】双指针，一个指向当前靠前的0的索引，一个指向当前遍历的num，找到非0则交换
    // 【时间复杂度】O(n)
    // 【空间复杂度】O(1)
//    public void moveZeroes(int[] nums) {
//        if (nums == null) return;
//        int zeroP = 0;
//        for (int curP = 0; curP < nums.length; curP++) {
//            if (nums[curP] != 0) {
//                if (zeroP != curP) {
//                    nums[zeroP] = nums[curP];
//                    nums[curP] = 0;
//                }
//                zeroP++;
//            }
//
//        }
//    }

    public void moveZeroes(int[] nums) {
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if(zero != i){
                    nums[zero] = nums[i];
                    nums[i] = 0;
                }
                zero++;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
