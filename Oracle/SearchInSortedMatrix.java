import java.util.*;
import java.io.*;
import java.lang.*;

class gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            int mat[][] = new int[n][m];
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < m; j++)
                  mat[i][j] = sc.nextInt();
            }
            
            int x = sc.nextInt();
            
            System.out.println (new Sol().matSearch(mat, n, m, x));
        }
        
    }
}// } Driver Code Ends


class Sol
{
    public static int matSearch(int mat[][], int N, int M, int X)
    {
        // your code here
        int left = 0, right = N*M-1;
        int mid, midElement;
        while(left <= right){
            mid = (left+right)/2;
            midElement = mat[mid/M][mid%M];
            if(X == midElement){
                return 1;
            } else {
                if(X < midElement){
                    right = mid-1;
                } else {
                    left = mid+1;
                }
            }
        }
        return 0;
    }
}
