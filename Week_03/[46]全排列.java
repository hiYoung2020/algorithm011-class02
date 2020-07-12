//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums = null;
    int[] visited = null;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return result;
        this.nums = nums;
        visited = new int[nums.length];
        helper(new LinkedList<Integer>());
        return result;
    }

    private void helper(Deque<Integer> stack) {
        if (stack.size() == nums.length) {
            result.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            stack.addLast(nums[i]);
            helper(stack);
            visited[i] = 0;
            stack.removeLast();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
