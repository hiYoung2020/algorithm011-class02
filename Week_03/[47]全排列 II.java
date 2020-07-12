//给定一个可包含重复数字的序列，返回所有不重复的全排列。 
//
// 示例: 
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums = null;
    boolean[] visited = null;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        this.nums = nums;
        visited = new boolean[nums.length];
        helper(new LinkedList<Integer>());
        return result;
    }

    private void helper(Deque<Integer> stack) {
        if (stack.size() == nums.length) {
            result.add(new ArrayList<Integer>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) continue;

            stack.addLast(nums[i]);
            visited[i] = true;
            helper(stack);
            visited[i] = false;
            stack.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
