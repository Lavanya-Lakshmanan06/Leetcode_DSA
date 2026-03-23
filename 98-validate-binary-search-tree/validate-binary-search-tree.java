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

 // method 1
// class Solution {
//     public boolean isValid(TreeNode root,long min,long max) {
//         if(root==null) return true;
//         if(root.val<=min || root.val>=max){
//              return false;
//         }
//         return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);
//     }
   
//     public boolean isValidBST(TreeNode root){
//         return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
    
//     }

// } 






class Solution {
    public boolean isValid(TreeNode root,long min,long max) {
        if(root==null) return true;
        if(root.val<=min || root.val>=max){
             return false;
        }
        return isValid(root.left,min,root.val) && isValid(root.right,root.val,max);
    }
    public  void inOrder(TreeNode root,ArrayList<Integer> list){
        if(root==null)return;
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }
    public boolean isValidBST(TreeNode root){
        // return isValid(root,Long.MIN_VALUE,Long.MAX_VALUE);
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(root,list);
        for(int i=0;i<list.size()-1;i++){
            if(list.get(i)>=list.get(i+1)){
                return false;
            }
            
        }
        return true;
    }

} 