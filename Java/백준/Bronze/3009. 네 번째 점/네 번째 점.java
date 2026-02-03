import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int ax = sc.nextInt();
        int ay = sc.nextInt();
        int bx = sc.nextInt();
        int by = sc.nextInt();
        int cx = sc.nextInt();
        int cy = sc.nextInt();
        
        int dx = 0;
        int dy = 0;
        
        if(ax == bx)    dx = cx;
        else if(ax == cx)    dx = bx;
        else if(bx == cx)    dx = ax;
        
        if(ay == by)    dy = cy;
        else if(ay == cy)    dy = by;
        else if(by == cy)    dy = ay;
        
        System.out.println(dx + " " + dy);
    }
}