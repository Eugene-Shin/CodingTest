import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int T = Integer.parseInt(br.readLine());
            
            for(int i = 0; i < T; i++) {
                String[] s = br.readLine().split("\\s");
                int M = Integer.parseInt(s[0]);
                int N = Integer.parseInt(s[1]);
                int K = Integer.parseInt(s[2]);
                
                int[][] map = new int[N][M];
                boolean[][] visited = new boolean[N][M];
            
                for(int j = 0; j < K; j++) {
                    String[] ss = br.readLine().split("\\s");
                    map[Integer.parseInt(ss[1])][Integer.parseInt(ss[0])] = 1;
                }
                
                int count = 0;
                
                for(int j = 0; j < N; j++) {
                    for(int k = 0; k < M; k++) {
                        if(visited[j][k] || map[j][k] == 0)    continue;
                        
                        count++;
                        dfs(map, visited, j, k);
                    }
                }
                bw.write(count + "\n");
            }
        }
    }
    
    public static void dfs(int[][] map, boolean[][] visited, int y, int x) {
        if(visited[y][x] || map[y][x] == 0)    return;
        
        visited[y][x] = true;
        
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length) {
                dfs(map, visited, ny, nx);
            }
        }
    }
}