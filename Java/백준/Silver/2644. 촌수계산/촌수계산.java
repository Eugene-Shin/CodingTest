import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static Deque<Integer> queue = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            int n = Integer.parseInt(br.readLine());
            graph = new ArrayList[n + 1];
            for(int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            visited = new boolean[n + 1];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            
            int m = Integer.parseInt(br.readLine());
            for(int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int n1 = Integer.parseInt(st.nextToken());
                int n2 = Integer.parseInt(st.nextToken());
                
                graph[n1].add(n2);
                graph[n2].add(n1);
            }
            
            System.out.println(chonSoo(start, end));
        }
    }
    
    public static int chonSoo(int start, int end) {
        int count = bfs(start, end);
        
        return count;
    }
    
    public static int bfs(int start, int end) {
        if(start == end)    return 0;
        
        int[] dist = new int[graph.length];
        queue.offerLast(start);
        visited[start] = true;
        
        while(!queue.isEmpty()) {
            int u = queue.pollFirst();
            
            for(int v : graph[u]) {
                if(!visited[v]) {
                    visited[v] = true;
                    queue.offerLast(v);
                    dist[v] = dist[u] + 1;
                    
                    if(v == end)    return dist[v];
                }
            }
        }
        
        return -1;
    }
}