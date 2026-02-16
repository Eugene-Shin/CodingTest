import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        permutation(N, M);
    }
    
    public static void permutation(int N, int M) throws IOException {
        boolean[] visited = new boolean[N];
        int[] arr = new int[M];
        
        dfs(0, arr, visited);
    }
    
    public static void dfs(int depth, int[] arr, boolean[] visited) throws IOException {
        if(depth == arr.length) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            
            for(int i = 0; i < arr.length; i++) {
                bw.write(arr[i] + "");
                if(i < arr.length - 1)   bw.write(" ");
            }
            bw.newLine();
            bw.flush();
            return;
        }
        
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(depth + 1, arr, visited);
                visited[i] = false;
            }
        }
    }
}