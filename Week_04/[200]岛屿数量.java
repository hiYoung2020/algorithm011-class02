//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    boolean[][] visited;
    int rows;
    int cols;
    char[][] grid;

    // 第一遍
    // 想法：每找到所有相邻（上下左右，注意边界）的1，并改为0
    // 时间：
    // 空间：
    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid == null || grid.length == 0) return result;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[rows][cols];
        this.grid = grid;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    result++;
                    dfs(i, j);
                }
            }
        }
        return result;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i == rows || j < 0 || j == cols || visited[i][j]) return;
        visited[i][j] = true;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(i + 1, j);
        dfs(i - 1, j);
        dfs(i, j + 1);
        dfs(i, j - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
