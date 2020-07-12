//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 第一遍：

    // 【想法】总共k个格子可以放数字，每个数在一组中只能出现一次
    // 【时间复杂度】
    // 【空间复杂度】O(n)

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        helper(n, k, 1, result, new LinkedList<Integer>());
        return result;
    }

    private void helper(int n, int k, int level, List<List<Integer>> result, Deque<Integer> cur) {
        if (cur.size() == k) {
            result.add(new ArrayList<Integer>(cur));
            return;
        }

        for (int i = level; i <= n; i++) {
            cur.addLast(i);
            helper(n, k, i + 1, result, cur);
            cur.removeLast();
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)
