import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            String S = br.readLine();
            int q = Integer.parseInt(br.readLine());
            int[][] cumulative_sum = new int[S.length() + 1][26];
            cumulative_sum[1][S.charAt(0) - 'a']++;
            for(int i = 2; i <= S.length(); i++) {
                for(int j = 0; j < 26; j++) {
                    cumulative_sum[i][j] = cumulative_sum[i - 1][j];
                }
                cumulative_sum[i][S.charAt(i - 1) - 'a']++;
                
            }
            while(q-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                char c = st.nextToken().charAt(0);
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                
                int count = cumulative_sum[r + 1][c - 'a'] - cumulative_sum[l][c - 'a'];
                
                bw.write(count + "");
                bw.newLine();
            }
        }
    }
}