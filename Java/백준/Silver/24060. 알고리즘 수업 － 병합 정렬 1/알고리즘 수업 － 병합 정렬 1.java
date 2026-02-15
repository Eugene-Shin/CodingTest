import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String[] nums = br.readLine().split("\\s");
            int N = Integer.parseInt(nums[0]);
            int K = Integer.parseInt(nums[1]);
            int[] A = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            
            System.out.println(kthSavedNum(A, K));
        }
    }
    
    static int count = 0;
    static int num = -1;
    public static int kthSavedNum(int[] A, int K) {
        count = 0;
        num = -1;
        mergeSort(A, 0, A.length - 1, K);
        return num;
    }
    
    public static void mergeSort(int[] A, int p, int r, int K) {
        if(p < r) {
            int q = (p + r) / 2;
            mergeSort(A, p, q, K);
            mergeSort(A, q + 1, r, K);
            merge(A, p, q, r, K);
        }
    }
    
    public static void merge(int[] A, int p, int q, int r, int K) {
        int i = p, j = q + 1, t = 0;
        int[] tmp = new int[r - p + 1];
        while(i <= q && j <= r) {
            if(A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }
        while(i <= q) {
            tmp[t++] = A[i++];
        }
        while(j <= r) {
            tmp[t++] = A[j++];
        }
        
        i = p;
        t = 0;
        while(i <= r) {
            A[i++] = tmp[t++];
            count++;
            if(count == K)
                num = A[i - 1];    //이미 1 증가했으므로
        }
    }
}