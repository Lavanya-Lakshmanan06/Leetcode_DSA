/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(root) {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> list = new ArrayList<>();

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        inorder(root.left);
        inorder(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        inorder(root);  
        return list;
    }
}
