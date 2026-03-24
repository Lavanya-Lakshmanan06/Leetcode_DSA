class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int time = 0;
        Queue<int[]> q = new LinkedList<>();

        // Step 1: Count fresh oranges & add rotten to queue
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // Directions (up, down, left, right)
        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

        // Step 2: BFS
        while (!q.isEmpty() && fresh > 0) {
            int size = q.size();
            time++;

            for (int k = 0; k < size; k++) {
                int[] curr = q.poll();
                int i = curr[0];
                int j = curr[1];

                for (int[] d : dirs) {
                    int ni = i + d[0];
                    int nj = j + d[1];

                    // Check bounds & fresh orange
                    if (ni >= 0 && ni < grid.length &&
                        nj >= 0 && nj < grid[0].length &&
                        grid[ni][nj] == 1) {

                        grid[ni][nj] = 2; // rot it
                        fresh--;
                        q.add(new int[]{ni, nj});
                    }
                }
            }
        }

        // Step 3: Result
        return fresh == 0 ? time : -1;
    }
}