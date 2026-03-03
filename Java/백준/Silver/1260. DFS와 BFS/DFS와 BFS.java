import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
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
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            
            graph = new ArrayList[N];
            for(int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
            }
            visited = new boolean[N];
            
            for(int i = 0; i < M; i++) {
                String[] s = br.readLine().split("\\s");
                graph[Integer.parseInt(s[0]) - 1].add(Integer.parseInt(s[1]));
                graph[Integer.parseInt(s[1]) - 1].add(Integer.parseInt(s[0]));
            }
            for(int i = 0; i < N; i++) {
                graph[i].sort(null);
            }
            
            dfs(V, bw);
            bw.newLine();
            for(int i = 0; i < N; i++) {
                visited[i] = false;
            }
            
            bfs(V, bw);
        }
    }
    
    public static void dfs(int V, BufferedWriter bw) throws IOException {
        visited[V - 1] = true;
        bw.write(V + " ");
        for(int i : graph[V - 1]) {
            if(!visited[i - 1]) {
                dfs(i, bw);
            }
        }
    }
    
    public static void bfs(int V, BufferedWriter bw) throws IOException {
        visited[V - 1] = true;
        queue.offerLast(V);
        while(!queue.isEmpty()) {
            int v = queue.pollFirst();
            bw.write(v + " ");
            
            for(int i : graph[v - 1]) {
                if(!visited[i - 1]) {
                    visited[i - 1] = true;
                    queue.offerLast(i);
                }
            }
        }
    }
}