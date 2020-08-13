//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Solution {
        // 剪枝：重复
        // private Map<Integer,Integer> map = new HashMap<>();
        // public int climbStairs(int n) {
        //     if(n<=2) return n;
        //     if(map.containsKey(n)) return map.get(n);
        //     int fn = climbStairs(n-1)+climbStairs(n-2);
        //     map.put(n,fn);
        //     return fn;
        // }

        // dp
        public int climbStairs(int n) {
            if (n <= 2) return n;

            int pre = 1;
            int cur = 2;
            for (int i = 3; i <= n; i++) {
                int temp = cur;
                cur = cur + pre;
                pre = temp;
            }
            return cur;
        }

    }

    // 第四遍：
    // 【想法】DP
    // 【时间复杂度】O(n)
    // 【空间复杂度】O(1)
//    public int climbStairs(int n) {
//        int result = 1;
//        int pre = 0;
//        int curr = 1;
//        for (int i = 1; i <= n; i++) {
//            result = pre + curr;
//            pre = curr;
//            curr = result;
//        }
//        return result;
//    }
//    Map<Integer, Integer> cache;
//
//    // 第四遍：
//    // 【想法】加速递归
//    // 【时间复杂度】O(n)
//    // 【空间复杂度】O(n)
//    public int climbStairs(int n) {
//        cache =new HashMap<>();
//        return dfs(n);
//    }
//
//    private int dfs(int n) {
//        if (n <= 3) return n;
//        if (cache.containsKey(n)) return cache.get(n);
//        int result = dfs(n - 1) + dfs(n - 2);
//        cache.put(n, result);
//        return result;
//    }
    // 第三遍：

    // 【想法】DP
    // 【时间复杂度】O(n)
    // 【空间复杂度】O(1)
//    public int climbStairs(int n) {
//        if (n <= 3) return n;
//        int dp1 = 1;
//        int dp2 = 2;
//        int result = 3;
//        for (int i = 3; i <= n; i++) {
//            result = dp1 + dp2;
//            dp1 = dp2;
//            dp2 = result;
//        }
//        return result;
//    }

    // 第三遍：
    // 【想法】递归，最近重复子问题：n = f(n-1) + f(n-2)
    // 【时间复杂度】O(n)
    // 【空间复杂度】O(n)
//    public int climbStairs(int n) {
//        return helper(n, new HashMap<Integer, Integer>());
//    }
//
//    private int helper(int n, Map<Integer, Integer> map) {
//        if (n <= 3) return n;
//        if (map.containsKey(n)) {
//            return map.get(n);
//        }
//        int i = helper(n - 1, map) + helper(n - 2, map);
//        map.put(n, i);
//        return i;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
