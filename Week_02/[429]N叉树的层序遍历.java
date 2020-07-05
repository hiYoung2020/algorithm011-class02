//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索


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

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    // 第一遍：

    // 【想法】 递归，给每个节点一个层序值，顺序添加到对应层序的list中
    // 【时间复杂度】O(n)
    // 【空间复杂度】O(最后一层节点空间，取最大幂次后为 n)
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(root, 0, result);
        return result;
    }

    public void helper(Node node, int level, List<List<Integer>> result) {
        if (node == null) return;
        if (result.size() <= level) result.add(new ArrayList<>());
        result.get(level).add(node.val);
        if (node.children != null) {
            for (Node child : node.children) {
                helper(child, level + 1, result);
            }
        }

    }
    // 第一遍：

    // 【想法】队列,广度优先
    // 【时间复杂度】O(n)
    // 【空间复杂度】O(最后一层节点空间，取最大幂次后为 n)
//    public List<List<Integer>> levelOrder(Node root) {
//        List<List<Integer>> result = new ArrayList<List<Integer>>();
//        if (root == null) return result;
//
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            List<Integer> signleLine = new ArrayList<>();
//            while (size-- > 0) {
//                Node curr = queue.remove();
//                signleLine.add(curr.val);
//                if (curr.children != null) queue.addAll(curr.children);
//            }
//            if (signleLine.size() > 0) result.add(signleLine);
//        }
//        return result;
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
