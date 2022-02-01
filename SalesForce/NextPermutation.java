
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        // code here
        int i = arr.length-2;
        while(i >= 0 && arr[i+1] <= arr[i]){
            i--;
        }
        if(i >= 0){
            int j = arr.length-1;
            while(arr[j] < arr[i]){
                j--;
            }
            swap(arr, i, j);
        }
        reverse(arr, i+1);
        List<Integer> res = new ArrayList<>();
        for(int j : arr){
            res.add(j);
        }
        return res;
    }
    
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static void reverse(int[] arr, int start){
        int i = start, j = arr.length-1;
        while(i < j){
            swap(arr, i, j);
            i++;
            j--;
        }
    }
}
