import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    static char[][] board;
    static boolean[][] visited;
    static Deque<Character> stack = new ArrayDeque<>();
    static int[] dy = {0, -1, 0, 1};
    static int[] dx = {1, 0, -1, 0};
    static int max = 0;
    
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            
            board = new char[R][C];
            visited = new boolean[R][C];
            
            for(int i = 0; i < R; i++) {
                String s = br.readLine();
                for(int j = 0; j < C; j++) {
                    board[i][j] = s.charAt(j);
                }
            }
            
            int[] count = {0};
            dfs(0, 0, count);
            
            System.out.println(max);
        }
    }
    
    public static void dfs(int y, int x, int[] count) {
        if(visited[y][x] || stack.contains(board[y][x]))    return;
        visited[y][x] = true;
        stack.push(board[y][x]);
        count[0]++;
        if(count[0] > max)    max = count[0];
        
        for(int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            
            if(ny >= 0 && nx >= 0 && ny < board.length && nx < board[0].length) {
                dfs(ny, nx, count);
            }
        }
        
        stack.pop();
        count[0]--;
        visited[y][x] = false;
    }
}