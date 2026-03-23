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

    // Helper class to store node with row & column
    class Tuple {
        TreeNode node;
        int row, col;

        Tuple(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // col -> row -> minHeap (to sort values)
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple curr = q.poll();

            TreeNode node = curr.node;
            int row = curr.row;
            int col = curr.col;

            // Initialize maps
            map.putIfAbsent(col, new TreeMap<>());
            map.get(col).putIfAbsent(row, new PriorityQueue<>());

            // Add value
            map.get(col).get(row).offer(node.val);

            // Traverse left & right
            if (node.left != null) {
                q.offer(new Tuple(node.left, row + 1, col - 1));
            }

            if (node.right != null) {
                q.offer(new Tuple(node.right, row + 1, col + 1));
            }
        }

        // Prepare result
        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {
            List<Integer> list = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values()) {
                while (!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            result.add(list);
        }

        return result;
    }
}