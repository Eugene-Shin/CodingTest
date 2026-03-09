import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static boolean[][] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            visited = new boolean[M][N];
            
            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int ldx = Integer.parseInt(st.nextToken());
                int ldy = Integer.parseInt(st.nextToken());
                int rux = Integer.parseInt(st.nextToken());
                int ruy = Integer.parseInt(st.nextToken());
                
                visit(ldx, ldy, rux, ruy);
            }
            
            for(int i = 0; i < M; i++) {
                for(int j = 0; j < N; j++) {
                    if(visited[i][j])    continue;
                    
                    list.add(dfs(i, j));
                }
            }
            
            bw.write(list.size() + "");
            bw.newLine();
            
            list.sort(null);
            for(int i = 0; i < list.size(); i++) {
                bw.write(list.get(i) + "");
                if(i < list.size() - 1)    bw.write(" ");
            }
        }
    }
    
    public static void visit(int ldx, int ldy, int rux, int ruy) {
        for(int i = ldy; i < ruy; i++) {
            for(int j = ldx; j < rux; j++) {
                visited[i][j] = true;
            }
        }
    }
    
    public static int dfs(int y, int x) {
        if(visited[y][x])    return 0;
        
        int count = 1;
        visited[y][x] = true;
        
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny >= 0 && nx >= 0 && ny < visited.length && nx < visited[0].length) {
                count += dfs(ny, nx);
            }
        }
        
        return count;
    }
}