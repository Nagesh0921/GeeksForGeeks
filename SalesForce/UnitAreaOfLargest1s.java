import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.findMaxArea(grid);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


class Solution
{
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid) {
        // Code here
        int rows = grid.length, cols = grid[0].length, maxArea = 0;
        boolean[][] isVisited = new boolean[rows][cols];
        for(int r=0; r<rows; r++){
            for(int c=0; c<cols; c++){
                maxArea = Math.max(maxArea, dfsWalk(grid, isVisited, r,c));
            }
        }
        return maxArea;
    }
    
    private int dfsWalk(int[][] grid, boolean[][] isVisited, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || isVisited[row][col] || grid[row][col] == 0){
            return 0;
        }
        isVisited[row][col] = true;
        return 1 + dfsWalk(grid, isVisited, row+1, col) + 
                    dfsWalk(grid, isVisited, row-1, col) +
                    dfsWalk(grid, isVisited, row, col+1) + 
                    dfsWalk(grid, isVisited, row, col-1) +
                    dfsWalk(grid, isVisited, row+1, col+1) + 
                    dfsWalk(grid, isVisited, row-1, col-1) + 
                    dfsWalk(grid, isVisited, row+1, col-1) + 
                    dfsWalk(grid, isVisited, row-1, col+1);
    }
}
