

import java.util.Arrays;
import java.util.HashMap;

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
    // 第一遍
    // 【想法】分析中序、后续特性，递归 拆分数组 左子树 root 右子树
    //      [inLL 左 root-1  |   root   |  inRL 右 inRR]
    //      [ 左|右|root]
    // 【时间复杂度】O()
    // 【空间复杂度】O()
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    //inorder => [inLeft,inRight]
    //postorder => [postLeft,postRight]

    // [left | root | right]
    // [left | right | root]
    private TreeNode buildTreeHelper(int[] inorder, int inLeft, int inRight,
                                     int[] postorder, int postLeft, int postRight, HashMap<Integer, Integer> map) {
        if (inRight < inLeft || postRight < postLeft) return null;
        int root = postorder[postRight];
        TreeNode rootNode = new TreeNode(root);
        Integer inorderRootIndex = map.get(root);
        rootNode.left = buildTreeHelper(inorder, inLeft, inorderRootIndex - 1, postorder, postLeft, postLeft + inorderRootIndex - inLeft - 1, map);
        rootNode.right = buildTreeHelper(inorder, inorderRootIndex + 1, inRight, postorder, postLeft + inorderRootIndex - inLeft, postRight - 1, map);
        return rootNode;
    }

}

//runtime:3 ms
//memory:40.2 MB
