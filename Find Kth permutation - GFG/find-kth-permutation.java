//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution {
    public static String kthPermutation(int n,int k) {
       boolean[] used = new boolean[n];
        int[] count = { 0 };
        int[] permutation = new int[n];
        
        generatePermutations(0, permutation, used, count, n, k);
        
        StringBuilder sb = new StringBuilder();
        for (int num : permutation) {
            sb.append(num);
        }
        return sb.toString();
    }
    
    private static void generatePermutations(int idx, int[] permutation, boolean[] used, int[] count, int n, int k) {
        if (idx == n) {
            count[0]++;
            if (count[0] == k) {
                return;
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (!used[i - 1]) {
                used[i - 1] = true;
                permutation[idx] = i;
                generatePermutations(idx + 1, permutation, used, count, n, k);
                if (count[0] == k) {
                    return;
                }
                used[i - 1] = false;
            }
        }
    }
}
        


//{ Driver Code Starts.

class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = IntArray.input(br, 2);
            
            Solution obj = new Solution();
            String res = obj.kthPermutation(a[0],a[1]);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends