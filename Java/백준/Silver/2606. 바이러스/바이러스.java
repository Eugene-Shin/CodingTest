import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static Deque<Integer> queue = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            int E = Integer.parseInt(br.readLine());
            
            graph = new ArrayList[N + 1];
            for(int i = 0; i < N + 1; i++) {
                graph[i] = new ArrayList<Integer>();
            }
            visited = new boolean[N + 1];
            
            for(int i = 0; i < E; i++) {
                String[] s = br.readLine().split("\\s");
                graph[Integer.parseInt(s[0])].add(Integer.parseInt(s[1]));
                graph[Integer.parseInt(s[1])].add(Integer.parseInt(s[0]));
            }
            
            bfs(1);
            
            int count = 0;
            for(int i = 1; i < visited.length; i++) {
                if(visited[i])    count++;
            }
            
            bw.write(--count + "");
        }
    }
    
    public static void bfs(int V) {
        visited[V] = true;
        queue.offerLast(V);
        
        while(!queue.isEmpty()) {
            int n = queue.pollFirst();
            
            for(int v : graph[n]) {
                if(!visited[v]) {
                    queue.offerLast(v);
                    visited[v] = true;
                }
            }
        }
    }
}