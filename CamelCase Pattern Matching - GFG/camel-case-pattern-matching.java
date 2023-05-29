//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String[] Dictionary=read.readLine().split(" ");
            String Pattern=read.readLine();
            Solution ob = new Solution();
            ArrayList <String> ans=ob.CamelCase(N,Dictionary,Pattern);
            for(String u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<String> CamelCase(int N,String[] Dictionary,String Pattern){
        //code here
        ArrayList<String> a=new ArrayList<>();
        Arrays.sort(Dictionary);
        for(int i=0;i<Dictionary.length;i++)
        {
            String x="";
            for(int j=0;j<Dictionary[i].length();j++)
            {
                if(Character.isUpperCase(Dictionary[i].charAt(j)))
                x+=Dictionary[i].charAt(j);
                if(x.length()==Pattern.length())
                break;
            }
            if(x.equals(Pattern))
            a.add(Dictionary[i]);
        }
        if(a.size()==0)
        a.add("-1");
        return a;
    }
}