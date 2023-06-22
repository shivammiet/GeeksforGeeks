//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        int count5 = 0;
        int count10 = 0;
        int count20 = 0;

        for (int bill : bills) {
            if (bill == 5) {
                count5++;
            } else if (bill == 10) {
                if (count5 > 0) {
                    count5--;
                    count10++;
                } else {
                    return false;
                }
            } else if (bill == 20) {
                if (count10 > 0 && count5 > 0) {
                    count10--;
                    count5--;
                    count20++;
                } else if (count5 >= 3) {
                    count5 -= 3;
                    count20++;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
