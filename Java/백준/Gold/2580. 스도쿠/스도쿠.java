import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try(
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int[][] sudoku = new int[9][9];
            
            int blankCount = 0;
            for(int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++) {
                    sudoku[i][j] = Integer.parseInt(st.nextToken());
                    if(sudoku[i][j] == 0)    blankCount++;
                }
            }
            
            solveSudoku(blankCount, sudoku, bw);
        }
    }
    
    public static void solveSudoku(int blankCount, int[][] sudoku, BufferedWriter bw) throws IOException {
        
        int[][] blanks = new int[blankCount][2];
        int k = 0;
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(sudoku[i][j] == 0) {
                    blanks[k][0] = i;
                    blanks[k++][1] = j;
                } 
            }
        }
        
        dfs(0, blanks, sudoku, bw);
    }
    
    public static boolean dfs(int depth, int[][] blanks, int[][] sudoku, BufferedWriter bw) throws IOException {
        if(depth == blanks.length) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    bw.write(sudoku[i][j] + "");
                    if(j < 8)    bw.write(" ");
                }
                bw.newLine();
            }
            return true;
        }
        
        int y = blanks[depth][0];
        int x = blanks[depth][1];
        
        for(int i = 1; i <= 9; i++) {
            boolean notExist = true;
            for(int j = 0; j < 9; j++) {
                if(sudoku[y][j] == i || sudoku[j][x] == i) {
                    notExist = false;
                    break;
                }
                if(!notExist) break;
            }
            for(int r = 0; r < 3; r++) {
                for(int c = 0; c < 3; c++) {
                    if(sudoku[(y / 3) * 3 + r][(x / 3) * 3 + c] == i) {
                        notExist = false;
                        break;
                    }
                }
                if(!notExist) break;
            }
            
            if(notExist) {
                sudoku[y][x] = i;
                if(dfs(depth + 1, blanks, sudoku, bw)) return true;
                sudoku[y][x] = 0;
            }
        }
        
        return false;
    }
}