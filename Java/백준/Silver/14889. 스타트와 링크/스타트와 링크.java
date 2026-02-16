import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ) {
            int N = Integer.parseInt(br.readLine());
            int[][] matrix = new int[N][N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            int[] minGap = { Integer.MAX_VALUE };
            makeTeam(matrix, minGap);
            System.out.println(minGap[0]);
        }
    }
    
    public static void makeTeam(int[][] matrix, int[] minGap) {
        //int[] teamA = new int[matrix.length / 2];
        //int[] teamB = new int[matrix.length / 2];
        boolean[] isTeamA = new boolean[matrix.length];
        
        dfs(0, 0, matrix, minGap, isTeamA);
        
    }
    public static void dfs(int depth, int start, int[][] matrix, int[] minGap, boolean[] isTeamA) {
        if(depth == matrix.length / 2) {
            int teamAScore = 0, teamBScore = 0;
            
            for(int i = 0; i < isTeamA.length; i++) {
                for(int j = i + 1; j < isTeamA.length; j++) {
                    if(isTeamA[i] && isTeamA[j])
                        teamAScore += (matrix[i][j] + matrix[j][i]);
                    if(!isTeamA[i] && !isTeamA[j])
                        teamBScore += (matrix[i][j] + matrix[j][i]);
                }
            }
            
            if(Math.abs(teamAScore - teamBScore) < minGap[0])
                minGap[0] = Math.abs(teamAScore - teamBScore);
            return;
        }
        
        for(int i = start; i < isTeamA.length; i++) {
            //teamA[i] = depth;
            //dfs(depth + 1, matrix, minGap, teamA, teamB);
            //teamB[i] = depth;
            //dfs(depth + 1, matrix, minGap, teamA, teamB);
            if(!isTeamA[i]) {
                isTeamA[i] = true;
                dfs(depth + 1, i + 1, matrix, minGap, isTeamA);
                isTeamA[i] = false;
            }
        }
    }
}