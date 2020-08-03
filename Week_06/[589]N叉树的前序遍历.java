//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


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

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;

        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            result.add(cur.val);
            for (int i = cur.children.size() - 1; i >= 0;i-- ) {
                stack.push(cur.children.get(i));
            }
        }
        return result;
    }
//    private List<Integer> list = new ArrayList<>();
//
//    public List<Integer> preorder(Node root) {
//        if (root != null) {
//            list.add(root.val);
//            for (Node node : root.children) {
//                preorder(node);
//            }
//        }
//        return list;
//    }



//
//
//    // 第一遍：
//    // 【想法】遍历模拟递归
//    // 【时间复杂度】O(n)
//    // 【空间复杂度】O(n)
//    public List<Integer> preorder(Node root) {
//        ArrayList<Integer> result = new ArrayList<>();
//        if (root == null) return result;
//
//        LinkedList<Node> stack = new LinkedList<>();
//        stack.add(root);
//        while (!stack.isEmpty()) {
//            Node node = stack.pop();
//            result.add(node.val);
//            if (node.children != null) {
//                for (int i = node.children.size() - 1; i >= 0; i--) {
//                    stack.addFirst(node.children.get(i));
//                }
//            }
//        }
//        return result;
//    }
    // 第一遍：
    // 【想法】递归
    // 【时间复杂度】O(n)
    // 【空间复杂度】O(n)：递归栈使用
//    public List<Integer> preorder(Node root) {
//        ArrayList<Integer> result = new ArrayList<>();
//        preorderRecursive(root, result);
//        return result;
//    }
//
//    public void preorderRecursive(Node root, ArrayList<Integer> result) {
//        if (root == null) {
//            return;
//        }
//        result.add(root.val);
//        if (root.children != null) {
//            for (int i = 0, size = root.children.size(); i < size; i++) {
//                preorderRecursive(root.children.get(i), result);
//            }
//        }
//
//    }

}
//leetcode submit region end(Prohibit modification and deletion)
