import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @description:
 * @author: yaodui
 * @time: 2022/8/22 17:37
 */

public class NumIslands {
    public List<Integer> list=new LinkedList<>();
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;

                    dfs(grid, i, j);//四个方向dfs
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
        //边界 或者搜索到0则返回
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public int bfsnumIsIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j);
                }
            }
        }
        return count;
    }


    private void bfs(char[][] grid, int x, int y) {
        grid[x][y] = '0';//置0
        int m=grid[x].length;
        int n=grid.length;
        int code=x*m+y;
        Queue<Integer>queue=new LinkedList<Integer>();
        queue.add(code);
        while (!queue.isEmpty()){
            //隊列非空持續向外擴展;
            int num=queue.poll();
            int i=num/m;
            int j=num%m;
            if(i>0&&grid[i-1][j]=='1'){
                grid[i-1][j]='0';
                queue.add((i-1)*m+j);
            }
            if(i<n-1&&grid[i+1][j]=='1'){
                grid[i+1][j]='0';
                queue.add((i+1)*m+j);
            }
            if(j>0&&grid[i][j-1]=='1'){
                grid[i][j-1]='0';
                queue.add(i*m+j-1);
            }
            if(j<m-1&&grid[i][j+1]=='1'){
                grid[i][j+1]='0';
                queue.add(i*m+j+1);
            }
        }
    }
}
