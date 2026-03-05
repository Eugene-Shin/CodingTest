import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] parents;
    
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            graph = new ArrayList[N + 1];
            for(int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            visited = new boolean[N + 1];
            parents = new int[N + 1];
            
            for(int i = 1; i < N; i++) {
                String[] s = br.readLine().split("\\s");
                int n1 = Integer.parseInt(s[0]);
                int n2 = Integer.parseInt(s[1]);
                
                graph[n1].add(n2);
                graph[n2].add(n1);
            }
            
            dfs(1, 0);
            
            for(int i = 2; i <= N; i++) {
                bw.write(parents[i] + "\n");
            }
        }
    }
    
    public static void dfs(int V, int parent) {
        visited[V] = true;
        parents[V] = parent;
        
        for(int i : graph[V]) {
            if(!visited[i]) {
                dfs(i, V);
            }
        }
    }
}