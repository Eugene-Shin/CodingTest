import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
        
        boolean[][] board = new boolean[N][N];
        System.out.println(nQueen(board));
    }
    
    public static int nQueen(boolean[][] board) {
        int[] count = new int[1];
        
        dfs(0, board, count);
        
        return count[0];
    }
    
    public static void dfs(int depth, boolean[][] board, int[] count) {
        if(depth == board.length) {
            count[0]++;
            return;
        }
        for(int i = 0; i < board.length; i++) {
            if(!board[depth][i] && isSafe(board, depth, i)) {
                board[depth][i] = true;
                dfs(depth + 1, board, count);
                board[depth][i] = false;
            }
        }
    }
    
    public static boolean isSafe(boolean[][] board, int y, int x) {
        for(int i = 0; i < y; i++) {
            if(board[i][x])
                return false;
        }
        
        for (int i = y - 1, j = x - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) return false;
        }
        
        for (int i = y - 1, j = x + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j]) return false;
        }
        
        return true;
    }
}