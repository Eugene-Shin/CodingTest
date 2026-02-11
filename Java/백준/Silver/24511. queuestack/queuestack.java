import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split("\\s");
            int[] A = new int[N];
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(s[i]);
            }
            s = br.readLine().split("\\s");
            int[] B = new int[N];
            for(int i = 0; i < N; i++) {
                B[i] = Integer.parseInt(s[i]);
            }
            Deque<Integer> deque = new LinkedList<>();
            for(int i = 0; i < N; i++) {
                if(A[i] == 0)
                    deque.offerLast(B[i]);
            }
            
            int M = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
                int num = Integer.parseInt(st.nextToken());
                
                //for(int j = 0; j < N; j++) {
                //    if(A[j] == 1) continue;
                //    else {
                //        int temp = B[j];
                //        B[j] = num;
                //        num = temp;
                //    }
                //}
                //bw.write(num + "");
                deque.offerFirst(num);
                bw.write(deque.pollLast() + "");
                
                if(i < M - 1)    bw.write(" ");
            }
        }
    }
}