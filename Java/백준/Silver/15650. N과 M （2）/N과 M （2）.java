import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String[] nums = br.readLine().split("\\s");
            int N = Integer.parseInt(nums[0]);
            int M = Integer.parseInt(nums[1]);
            
            int[] arr = new int[M];
            dfs(0, 0, N, arr, bw);
        }
    }
    
    public static void dfs(int depth, int start, int end, int[] permutation, BufferedWriter bw) throws IOException {
        if(depth == permutation.length) {
            for(int i = 0; i < permutation.length; i++) {
                bw.write(permutation[i] + "");
                if(i < permutation.length - 1)    bw.write(" ");
            }
            bw.newLine();
            return;
        }
        
        for(int i = start; i < end; i++) {
            permutation[depth] = i + 1;
            
            dfs(depth + 1, i + 1, end, permutation, bw);
        }
    }
}