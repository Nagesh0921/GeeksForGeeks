// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args)throws IOException
	{

// 		Scanner in = new Scanner(System.in);
        
// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
         //testcases
        int t = Integer.parseInt(read.readLine());
		
		while(t-- >0)
		{
		    //size of array
		    int n = Integer.parseInt(read.readLine());
		    int[] temp= new int[n];
		    
		    String str[] = read.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0;i<n;i++)
		        temp[i] = Integer.parseInt(str[i]);
		    
		    // StringBuffer sb = new StringBuffer();
		    
		    Solution ob = new Solution();
		    
		    //calling rearrange() function
		    ob.rearrange(temp, n);
		    StringBuffer sb = new StringBuffer();
		    
		    //appending and printing the elements
		    for(int i =0; i < n; i++)
		     sb.append(temp[i] + " ");
		    System.out.println(sb);
		}
	}
}



// } Driver Code Ends




class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(int arr[], int n){
        // Your code here
        int len = arr.length, start = 0, maxIndex = arr.length-1, minIndex = 0, maxValue = arr[len-1]+1;
        if(len <= 1){
            return;
        }
        for(int i=0; i<len; i++){
            if((i&1) == 0){
                arr[i] += (arr[maxIndex--]%maxValue)*maxValue;
            } else {
                arr[i] += (arr[minIndex++]%maxValue)*maxValue;
            }
        }
        for(int i=0; i<len; i++){
            arr[i] = arr[i]/maxValue;
        }
    }
    
}


//Time Complexity O(N) and Space Complexity is O(1)
