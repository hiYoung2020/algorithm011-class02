//给定一个 N 叉树，找到其最大深度。 
//
// 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 我们应返回其最大深度，3。 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总不会超过 5000。 
// Related Topics 树 深度优先搜索 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int maxLevel = 0;
    // 第一遍：

    // 【想法】 深度优先，统计maxlevel
    // 【时间复杂度】O(n)
    // 【空间复杂度】O(n)
    public int maxDepth(Node root) {
        if (root == null) return 0;
        helper(root, 1);
        return maxLevel;
    }

    private void helper(Node root, int deep) {
        if (root.children == null || root.children.size() == 0) {
            maxLevel = Math.max(maxLevel, deep);
            return;
        }
        for (int i = 0, size = root.children.size(); i < size; i++) {
            helper(root.children.get(i), deep + 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
