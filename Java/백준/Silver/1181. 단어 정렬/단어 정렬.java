import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        try(
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int N = Integer.parseInt(br.readLine());
            String[] words = new String[N];
            for(int i = 0; i < N; i++) {
                words[i] = br.readLine();
            }
            Arrays.sort(words, (a, b) -> {
                if(a.length() == b.length()) {
                    int i = 0;
                    for(; i < a.length(); i++) {
                        if(a.charAt(i) != b.charAt(i))    return a.charAt(i) - b.charAt(i);
                    }
                }
                return a.length() - b.length();
            });
            for(int i = 0; i < N - 1; i++) {
                for(int j = i + 1; j < N; j++) {
                    if(words[i].equals(words[j]))
                        words[j] = "*";
                }
            }
            for(int i = 0; i < N; i++) {
                if(!"*".equals(words[i])) {
                    bw.write(words[i]);
                    bw.newLine();
                }
            }
        }
    }
}