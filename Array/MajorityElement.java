// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size){
        // your code here
        //We can use Brute-Force, basically 2 for loops get the count and compare it with max count;
        //TC: O(n^2), SC: O(1)
        //Optimized One: HashMap, get the count as values against the key and then get maximum count
        //TC: O(N), SC: O(N)
        //Boyce and Moyre Algo -> Voting Algorithm
        //TC: O(N), SC: O(1)
        Integer candidate = findCandidate(a);
        return (isMajority(a, candidate)) ? candidate : -1;
    }
    
    static int findCandidate(int[] a){
        int count = 0;
        Integer candidate = null;
        for(int n : a){
            if(count == 0){
                candidate = n;
            }
            count += (candidate == n) ? 1 : -1;
        }
        return candidate;
    }
    
    static boolean isMajority(int[] a, int candidate){
        int count = 0;
        for(int n : a){
            if(candidate == n){
                count++;
            }
        }
        if(count > (a.length/2)){
            return true;
        }
        return false;
    }
}
