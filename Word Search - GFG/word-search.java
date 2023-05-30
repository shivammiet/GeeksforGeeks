//{ Driver Code Starts
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
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution {
    public boolean isWordExist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.length() == 0) {
            return false;
        }
        
        int rows = board.length;
        int cols = board[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        // Iterate through each cell on the board
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, visited, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, boolean[][] visited, String word, int row, int col, int index) {
        // Check if the current cell is out of bounds or already visited
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || visited[row][col]) {
            return false;
        }
        
        // Check if the current cell matches the corresponding character in the word
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
        
        // Check if the word is found
        if (index == word.length() - 1) {
            return true;
        }
        
        // Mark the current cell as visited
        visited[row][col] = true;
        
        // Recursively check neighboring cells
        boolean exists = dfs(board, visited, word, row + 1, col, index + 1)
            || dfs(board, visited, word, row - 1, col, index + 1)
            || dfs(board, visited, word, row, col + 1, index + 1)
            || dfs(board, visited, word, row, col - 1, index + 1);
        
        // Restore the visited status of the current cell
        visited[row][col] = false;
        
        return exists;
    }
}