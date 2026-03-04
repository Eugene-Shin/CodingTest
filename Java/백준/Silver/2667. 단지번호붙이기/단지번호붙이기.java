import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N][N];
            boolean[][] visited = new boolean[N][N];
            
            for(int i = 0; i < N; i++) {
                String s = br.readLine();
                for(int j = 0; j < N; j++) {
                    map[i][j] = s.charAt(j) - '0';
                }
            }
            
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 0; i < visited.length; i++) {
                for(int j = 0; j < visited[0].length; j++) {
                    if(map[i][j] == 0 || visited[i][j])    continue;
                    
                    int[] count = { 0 };
                    dfs(map, visited, i, j, count);
                    list.add(count[0]);
                }
            }
            
            bw.write(list.size() + "\n");
            
            list.sort(null);
            for(int i : list) {
                bw.write(i + "\n");
            }
        }
    }
    
    public static void dfs(int[][] map, boolean[][] visited, int i, int j, int[] count) {
            if(!visited[i][j] && map[i][j] == 1) {
                visited[i][j] = true;
                count[0]++;
                
                if(i > 0)    dfs(map, visited, i - 1, j, count);
                if(i < visited.length - 1)    dfs(map, visited, i + 1, j, count);
                if(j > 0)    dfs(map, visited, i, j - 1, count);
                if(j < visited[0].length - 1)    dfs(map, visited, i, j + 1, count);
            }
        }
}