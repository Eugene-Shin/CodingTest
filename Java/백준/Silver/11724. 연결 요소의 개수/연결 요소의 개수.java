import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String[] s = br.readLine().split("\\s");
            int N = Integer.parseInt(s[0]);
            int M = Integer.parseInt(s[1]);
            
            graph = new ArrayList[N + 1];
            for(int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
            }
            visited = new boolean[N + 1];
            
            for(int i = 0; i < M; i++) {
                String[] ss = br.readLine().split("\\s");
                int n1 = Integer.parseInt(ss[0]);
                int n2 = Integer.parseInt(ss[1]);
                
                graph[n1].add(n2);
                graph[n2].add(n1);
            }
            
            bw.write(countCC() + "");
        }
    }
    
    public static int countCC() {
        int count = 0;
        
        for(int i = 1; i < graph.length; i++) {
            if(visited[i])    continue;
            
            dfs(i);
            count++;
        }
        
        return count;
    }
    
    public static void dfs(int V) {
        if(visited[V])    return;
        visited[V] = true;
        
        for(int v : graph[V]) {
            if(!visited[v]) {
                dfs(v);
            }
        }
    }
}