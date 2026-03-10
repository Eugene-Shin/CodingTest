import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] drawing;
    static boolean[][] visited;
    static int maxSize = 0;
    static int[] dy = { 0, -1, 0, 1 };
    static int[] dx = { 1, 0, -1, 0 };
    
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            drawing = new int[n][m];
            visited = new boolean[n][m];
            
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < m; j++) {
                    drawing[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int count = 0;
            
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(visited[i][j] || drawing[i][j] == 0)    continue;
                    
                    int size = dfs(i, j);
                    if(size > maxSize)    maxSize = size;
                    count++;
                }
            }
            
            System.out.println(count);
            System.out.println(maxSize);
        }
    }
    
    public static int dfs(int y, int x) {
        visited[y][x] = true;
        int size = 1;
        
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny >= 0 && nx >= 0 && ny < drawing.length && nx < drawing[0].length && !visited[ny][nx] && drawing[ny][nx] == 1) {
                size += dfs(ny, nx);
            }
        }
        
        return size;
    }
}