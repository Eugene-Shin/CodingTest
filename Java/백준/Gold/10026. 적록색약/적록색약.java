import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int[] dy = { 0, -1, 0, 1 };
    static int[] dx = { 1, 0, -1, 0 };
    
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            int N = Integer.parseInt(br.readLine());
            char[][] painting = new char[N][N];
            for(int i = 0; i < N; i++) {
                String s = br.readLine();
                for(int j = 0; j < N; j++) {
                    painting[i][j] = s.charAt(j);
                }
            }
            
            countArea(painting);
            System.out.print(" ");
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(painting[i][j] == 'G')    painting[i][j] = 'R';
                }
            }
            
            countArea(painting);
        }
    }
    
    public static void countArea(char[][] painting) {
        int count = 0;
        boolean[][] visited = new boolean[painting.length][painting[0].length];
        
        
        for(int i = 0; i < painting.length; i++) {
            for(int j = 0; j < painting[0].length; j++) {
                if(visited[i][j])    continue;
                
                count++;
                dfs(painting, visited, i, j, painting[i][j]);
            }
        }
        
        System.out.print(count);
    }
    
    public static void dfs(char[][] painting, boolean[][] visited, int y, int x, char c) {
        if(visited[y][x] || c != painting[y][x])    return;
        
        visited[y][x] = true;
        
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny >= 0 && ny < painting.length && nx >= 0 && nx < painting[0].length) {
                dfs(painting, visited, ny, nx, c);
            }
        }
    }
}