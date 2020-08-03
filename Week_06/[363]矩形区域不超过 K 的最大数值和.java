//给定一个非空二维矩阵 matrix 和一个整数 k，找到这个矩阵内部不大于 k 的最大矩形和。 
//
// 示例: 
//
// 输入: matrix = [[1,0,1],[0,-2,3]], k = 2
//输出: 2 
//解释: 矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
// 
//
// 说明： 
//
// 
// 矩阵内的矩形区域面积必须大于 0。 
// 如果行数远大于列数，你将如何解答呢？ 
// 
// Related Topics 队列 二分查找 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 1 [ 0 1]   1  1 2
    // 0 [-2 3]   1 -1 2
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return 0;
        int result = Integer.MIN_VALUE;
        for (int left = 0; left < matrix[0].length; left++) {
            int[] arrs = new int[matrix.length];
            for (int right = 0; right < matrix[0].length; right++) {
                for (int m = 0; m < matrix.length; m++) {
                    arrs[m] += matrix[m][right];
                }
                result = Math.max(result, getMaxSubMatrixSum(arrs, k));
                if (result == k) break;
            }
        }
        return result;
    }

    private int getMaxSubMatrixSum(int[] arrs, int k) {
        if (arrs == null || arrs.length == 0) return 0;
        int maxSum = Integer.MIN_VALUE;
        for (int l = 0; l < arrs.length; l++) {
            int sum = 0;
            for (int r = 0; r < arrs.length; r++) {
                sum += arrs[r];
                if (sum > maxSum && sum <= k) maxSum = sum;
                if (maxSum == k) break;
            }
        }
        return maxSum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
