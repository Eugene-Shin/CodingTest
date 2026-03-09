import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            while(true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int w = Integer.parseInt(st.nextToken());
                int h = Integer.parseInt(st.nextToken());
                if(w == 0 && h == 0)    break;
                
                map = new int[h][w];
                visited = new boolean[h][w];
                for(int i = 0; i < h; i++) {
                    st = new StringTokenizer(br.readLine());
                    for(int j = 0; j < w; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                
                int count = 0;
                
                for(int i = 0; i < h; i++) {
                    for(int j = 0; j < w; j++) {
                        if(visited[i][j] || map[i][j] == 0)    continue;
                        
                        dfs(i, j);
                        count++;
                    }
                }
                
                bw.write(count + "\n");
            }
        }
    }
    
    public static void dfs(int y, int x) {
        if(visited[y][x] || map[y][x] == 0)    return;
        visited[y][x] = true;
        
        for(int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny >= 0 && nx >= 0 && ny < map.length && nx < map[0].length) {
                dfs(ny, nx);
            }
        }
    }
}