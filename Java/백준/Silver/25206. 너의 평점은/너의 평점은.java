import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        double avg = 0.0;
        double totalCredit = 0.0;
        
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            for(int i = 0; i < 20; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String subject = st.nextToken();
                double credit = Double.parseDouble(st.nextToken());
                String achivement = st.nextToken();
                double score = 0.0;
                
                totalCredit += credit;
                
                if(achivement.equals("A+"))    score = 4.5;
                else if(achivement.equals("A0"))    score = 4.0;
                else if(achivement.equals("B+"))    score = 3.5;
                else if(achivement.equals("B0"))    score = 3.0;
                else if(achivement.equals("C+"))    score = 2.5;
                else if(achivement.equals("C0"))    score = 2.0;
                else if(achivement.equals("D+"))    score = 1.5;
                else if(achivement.equals("D0"))    score = 1.0;
                else if(achivement.equals("F"))    score = 0.0;
                else if(achivement.equals("P")) {
                    totalCredit -= credit;
                    score = 0.0;
                }    
                
                avg += (credit * score);
            }
        }
        
        avg /= totalCredit;
        System.out.println(avg);
    }
}