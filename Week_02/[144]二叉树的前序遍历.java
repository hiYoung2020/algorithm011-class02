//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


//leetcode submit region begin(Prohibit modification and deletion)


import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if(curr.right != null) stack.push(curr.right);
            if(curr.left != null) stack.push(curr.left);
        }
        return result;
    }
//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        helper(root, result);
//        return result;
//    }
//
//    public void helper(TreeNode root, List<Integer> result) {
//        if (root == null) return;
//        result.add(root.val);
//        helper(root.left, result);
//        helper(root.right, result);
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
