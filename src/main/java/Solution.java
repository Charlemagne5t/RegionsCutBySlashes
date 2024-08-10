class Solution {
    public int regionsBySlashes(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        char[][] g = new char[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                g[i][j] = grid[i].charAt(j); 
            }
        }
        int res = 0;
        int[][] vis = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(vis[i][j] == 3){
                    continue;
                } else if (g[i][j] == '/') {
                    if(vis[i][j] == 0) {
                        res++;
                        bfs(g, i, j, vis, 'N');
                        if(vis[i][j] == 1) {
                            res++;
                            bfs(g, i, j, vis, 'S');
                        }
                    }else if(vis[i][j] == 1) {
                        res++;
                        bfs(g, i, j, vis, 'S');
                    }else{
                        res++;
                        bfs(g, i, j, vis, 'N');
                    }
                }else if (g[i][j] == '\\') {
                    if(vis[i][j] == 0) {
                        res++;
                        bfs(g, i, j, vis, 'S');
                        if(vis[i][j] == 1) {
                            res++;
                            bfs(g, i, j, vis, 'N');
                        }
                    }else if(vis[i][j] == 1) {
                        res++;
                        bfs(g, i, j, vis, 'N');
                    }else{
                        res++;
                        bfs(g, i, j, vis, 'S');
                    }
                }

            }
        }
        

        return res;
    }
    void bfs(char[][] grid, int i, int j, int[][] vis, char from){
        int m = grid.length;
        int n = grid[0].length;
        if(i < 0 || i == m || j < 0 || j == n || vis[i][j] == 3) {
            return;
        }
        if(grid[i][j] == ' ') {
            vis[i][j] = 3;
            bfs(grid, i + 1, j, vis, 'N');
            bfs(grid, i - 1, j, vis, 'S');
            bfs(grid, i, j - 1, vis, 'E');
            bfs(grid, i, j + 1, vis, 'W');
        }else if(grid[i][j] == '/' && (from == 'N' || from == 'W')) {
            if(vis[i][j] == 1){
                return;
            }
            vis[i][j]++;
            bfs(grid, i - 1, j, vis, 'S');
            bfs(grid, i, j - 1, vis, 'E');
        }else if(grid[i][j] == '/'  && (from == 'S' || from == 'E')){
            if(vis[i][j] == 2) {
                return;
            }
            vis[i][j] += 2;
            bfs(grid, i + 1, j, vis, 'N');
            bfs(grid, i, j + 1, vis, 'W');
        }else if(grid[i][j] == '\\' && (from == 'S' || from == 'W')) {
            if(vis[i][j] == 1){
                return;
            }
            vis[i][j]++;
            bfs(grid, i + 1, j, vis, 'N');
            bfs(grid, i, j - 1, vis, 'E');
        }else if(grid[i][j] == '\\' && (from == 'N' || from == 'E')){
            if(vis[i][j] == 2) {
                return;
            }
            vis[i][j] += 2;
            bfs(grid, i - 1, j, vis, 'S');
            bfs(grid, i, j + 1, vis, 'W');
        }
        
    }
}