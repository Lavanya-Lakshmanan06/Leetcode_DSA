/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list1=new ArrayList<>();
        if(root==null) return list1;
        boolean flag=true;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> list2=new ArrayList<>();
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode x=q.poll();
                list2.add(x.val);
                if(x.left!=null) q.add(x.left);
                if(x.right!=null) q.add(x.right);
            }
            if(!flag)
                Collections.reverse(list2);
            list1.add(list2);
            flag=!flag;
        }
        return list1;
    }
}