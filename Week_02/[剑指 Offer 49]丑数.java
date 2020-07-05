//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。 
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 第一遍：
    // 【想法】DP
    // 【时间复杂度】O(n)
    // 【空间复杂度】O(n)
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;
        for (int i = 1; i < n; i++) {
            int a = dp[p2] * 2;
            int b = dp[p3] * 3;
            int c = dp[p5] * 5;
            dp[i] = Math.min(Math.min(a, b), c);
            if(dp[i] == a) p2++;
            if(dp[i] == b) p3++;
            if(dp[i] == c) p5++;
        }
        return dp[n - 1];
    }


}
//leetcode submit region end(Prohibit modification and deletion)
