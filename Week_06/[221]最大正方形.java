//在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。 
//
// 示例: 
//
// 输入: 
//
//1 0 1 0 0
//1 0 1 1 1
//1 1 1 1 1
//1 0 0 1 0
//
//输出: 4 
// Related Topics 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 第一遍：
    // 【想法】dp优化空间，只保留最近相关性
    // 【时间复杂度】O(m*n)
    // 【空间复杂度】O(n)：
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int side = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        // 初始化状态（二维矩阵，每个格子代表最大正方形边长）
        // 0000
        //  111
        //  111
        int[] dp = new int[n + 1];
        int nextWestNorth = 0;
        for (int i = 0; i < m; i++) {
            int westNorth = 0;
            for (int j = 0; j < n; j++) {
                nextWestNorth = dp[j + 1];
                if (matrix[i][j] == '1') {
                    dp[j + 1] = Math.min(Math.min(westNorth, dp[j]), dp[j + 1]) + 1;
                    side = Math.max(side, dp[i + 1][j + 1]);
                }else{
                    dp[j + 1] = 0;
                }
                westNorth = nextWestNorth;
            }
        }
        return side * side;
    }

    // 第一遍：
    // 【想法】m == n为正方形；全是1；matrix[m][n]为右下角判定：Min(左上连续1，左下连续1，右上连续1)
    // 【时间复杂度】O(m*n)
    // 【空间复杂度】O(m*n)：
//    public int maximalSquare(char[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
//        int side = 0;
//        int m = matrix.length;
//        int n = matrix[0].length;
//        // 初始化状态（二维矩阵，每个格子代表最大正方形边长）
//        // 0000
//        // 0111
//        // 0111
//        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (matrix[i][j] == '1') {
//                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i + 1][j]), dp[i][j + 1]) + 1;
//                    side = Math.max(side, dp[i + 1][j + 1]);
//                }
//            }
//        }
//        return side * side;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
