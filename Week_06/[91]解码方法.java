//一条包含字母 A-Z 的消息通过以下方式进行了编码： 
//
// 'A' -> 1
//'B' -> 2
//...
//'Z' -> 26
// 
//
// 给定一个只包含数字的非空字符串，请计算解码方法的总数。 
//
// 示例 1: 
//
// 输入: "12"
//输出: 2
//解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
// 
//
// 示例 2: 
//
// 输入: "226"
//输出: 3
//解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
// 
// Related Topics 字符串 动态规划


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') return 0;
        int pre = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            char p = s.charAt(i - 1);
            int temp = cur;
            if (c == '0') {
                if (p != '1' && p != '2') return 0;
                cur = pre;
            } else if (p == '1' || (p == '2' && (c >= '0' && c <= '6'))) {
                cur = cur + pre;
            }
            pre = temp;
        }
        return cur;
    }


    int result;
    String s;

    // 第一遍：
    // 【想法】递归解决
    // 【时间复杂度】O()
    // 【空间复杂度】O()：
//    public int numDecodings(String s) {
//        if (s == null || s.isEmpty()) return 0;
//        this.s = s;
//        recurse(0, 1);
//        return result;
//    }

    private void recurse(int begin, int end) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)
