//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 第三遍：
    // 【想法】最值考虑dp
    //      子问题：达到(i,j)格子的最小值，来自于Min((i,j-1),(i-1,j))
    //      定义状态：dp(i,j) 代表到达(i,j)的最小值
    //      状态转移方程：dp(i,j) = Min(dp(i,j-1),dp(i-1,j)) + grid[i][j]
    //      状态初始化：1.dp填充上最大值，防止对有效值的干扰；2.每层开始时， dp[0] = dp[0] + grid[i][j]
    //      状态压缩：左侧在当前层，缓存上侧一层即可
    // 【时间复杂度】O(m*n)
    // 【空间复杂度】O(n)
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[n - 1];
    }


    // 第二遍：
    // 【想法】推导：每个格子的路径和，只能在它右侧与下侧中选择更小的，就是当前格子的最小路径和，之后重复这一个判断
    // 【时间复杂度】O(m*n)
    // 【空间复杂度】O(m*n)：由于只需要上一层的状态，可压缩至O(n)
//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int[] dp = new int[n];
//        Arrays.fill(dp, Integer.MAX_VALUE);
//        dp[0] = 0;
//        for (int i = 0; i < m; i++) {
//            dp[0] = dp[0] + grid[i][0];
//            for (int j = 1; j < n; j++) {
//                dp[j] = grid[i][j] + Math.min(dp[j - 1], dp[j]);
//            }
//        }
//        return dp[n - 1];
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
