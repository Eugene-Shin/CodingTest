import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] graph;
    static int[] mark;
    static boolean isBinaryGraph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            int K = Integer.parseInt(br.readLine());
            
            for(int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int V = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                
                graph = new ArrayList[V + 1];
                for(int j = 1; j <= V; j++) {
                    graph[j] = new ArrayList<>();
                }
                mark = new int[V + 1];
                visited = new boolean[V + 1];
                
                for(int j = 0; j < E; j++) {
                    st = new StringTokenizer(br.readLine());
                    int n1 = Integer.parseInt(st.nextToken());
                    int n2 = Integer.parseInt(st.nextToken());
                    
                    graph[n1].add(n2);
                    graph[n2].add(n1);
                }
                
                isBinaryGraph = true;
                for(int j = 1; j <= V; j++) {
                    if(!isBinaryGraph)    break;
                    if(visited[j])    continue;
                    
                    mark[j] = 1;
                    dfs(j);
                }
                
                System.out.println(isBinaryGraph ? "YES" : "NO");
            }
        }
    }
    
    public static void dfs(int v) {
        if(!isBinaryGraph)    return;
        visited[v] = true;
        
        for(int u : graph[v]) {
            if(mark[u] == mark[v]) {
                isBinaryGraph = false;
                return;
            }
            if(mark[u] == 0) {
                mark[u] = -mark[v];
                dfs(u);
            }
        }
    }
}