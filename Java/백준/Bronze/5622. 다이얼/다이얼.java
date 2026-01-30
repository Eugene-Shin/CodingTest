import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int answer = 0;
        
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= 'A' && c <= 'C') {
                answer += 3;
            } else if(c >= 'D' && c <= 'F') {
                answer += 4;
            } else if(c >= 'G' && c <= 'I') {
                answer += 5;
            } else if(c >= 'J' && c <= 'L') {
                answer += 6;
            } else if(c >= 'M' && c <= 'O') {
                answer += 7;
            } else if(c >= 'P' && c <= 'S') {
                answer += 8;
            } else if(c >= 'T' && c <= 'V') {
                answer += 9;
            } else if(c >= 'W' && c <= 'Z') {
                answer += 10;
            }
        }
        
        System.out.println(answer);
    }
}