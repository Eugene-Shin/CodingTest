import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N][N];
            int maxHeight = 0;
            int maxAreaCount = 0;
            
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] > maxHeight)    maxHeight = map[i][j];
                }
            }
            
            for(int i = 0; i <= maxHeight; i++) {
                int count = 0;
                
                for(int j = 0; j < N; j++) {
                    for(int k = 0; k < N; k++) {
                        if(map[j][k] <= i)    visited[j][k] = true;
                    }
                }
                
                for(int j = 0; j < N; j++) {
                    for(int k = 0; k < N; k++) {
                        if(visited[j][k])    continue;
                        
                        dfs(j, k);
                        count++;
                    }
                }
                
                if(count > maxAreaCount)    maxAreaCount = count;
                
                for(int j = 0; j < N; j++) {
                    for(int k = 0; k < N; k++) {
                        visited[j][k] = false;
                    }
                }
            }
            System.out.println(maxAreaCount);
        }
    }
    
    public static void dfs(int y, int x) {
        if(visited[y][x])    return;
        
        visited[y][x] = true;
        
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length) {
                dfs(ny, nx);
            }
        }
    }
}