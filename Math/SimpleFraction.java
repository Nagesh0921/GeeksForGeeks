// { Driver Code Starts
//Initial Template for Java

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
            String[] S = br.readLine().trim().split(" ");
            int numerator = Integer.parseInt(S[0]);
            int denominator = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            String ans = ob.fractionToDecimal(numerator, denominator);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String  fractionToDecimal(int numerator, int denominator){
        // code here
	    StringBuilder res = new StringBuilder();
	    //Test Case:1,2 Numerator & Denominator is Zero : Not Valid due to Constraints mentioned.
	    //Test Case:3 if one of them is negative
	    if(numerator < 0 || denominator < 0){
	        res.append("-");
	    }
	    //Convert both in long to avoid any integer overflows
	    long dividend = Math.abs(Long.valueOf(numerator));
	    long divisor = Math.abs(Long.valueOf(denominator));
	    res.append(String.valueOf(dividend/divisor));
	    long remainder = dividend%divisor;
	    if(remainder == 0){
	        return res.toString();
	    }
	    res.append(".");
	    Map<Long, Integer> map = new HashMap<>();
	    while(remainder != 0){
	        if(map.containsKey(remainder)){
	            res.insert(map.get(remainder), "(");
	            res.append(")");
	            break;
	        }
	        map.put(remainder, res.length());
	        remainder *= 10;
	        res.append(String.valueOf(remainder/divisor));
	        remainder %= divisor;
	    }
	    return res.toString();
    }
}
