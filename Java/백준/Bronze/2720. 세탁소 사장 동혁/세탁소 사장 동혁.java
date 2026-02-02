import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int i = 0; i < T; i++) {
            int change = sc.nextInt();
            int quarter = 0;  //0.25
            int dime = 0;    //0.10
            int nickel = 0;  //0.05
            int penny = 0;       //0.01
                
            while(change >= 25) {
                change -= 25;
                quarter++;
            }
            while(change >= 10) {
                change -= 10;
                dime++;
            }
            while(change >= 5) {
                change -= 5;
                nickel++;
            }
            while(change >= 1) {
                change -= 1;
                penny++;
            }
            
            System.out.println(quarter + " " + dime + " " + nickel + " " + penny);
        }
    }
}