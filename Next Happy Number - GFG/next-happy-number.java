//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
   static int isCheck(int N){
       
       if(N==1||N==7)
       return 1;
       
       int curr=N;
       int sum=N;
       
       while(sum>9){
           sum=0;
           while(curr>0){
               int d=curr%10;
               sum=sum+d*d;
               curr=curr/10;
           }
           curr=sum;
           if(sum==1||sum==7)
           return 1;
           
           
           
       }
        
  return 0; }
    static int nextHappy(int N){
        // code here
        int next=N+1;
        
        while(true){
            if(isCheck(next)==1)
                return next;
           next++;
        }
    }
}