import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        try(
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))
        ) {
            int N = Integer.parseInt(br.readLine());
            int[] nums = new int[N];
            int[] op = new int[4];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 4; i++) {
                op[i] = Integer.parseInt(st.nextToken());
            }
            
            int[] maxMin = { Integer.MIN_VALUE, Integer.MAX_VALUE };
            generateForm(nums, op, maxMin);
            System.out.println(maxMin[0]);
            System.out.println(maxMin[1]);
        }
    }
    
    public static void generateForm(int[] nums, int[] op, int[] maxMin) {
        int temp = nums[0];
        dfs(1, temp, nums, op, maxMin);
    }
    
    public static void dfs(int depth, int temp, int[] nums, int[] op, int[] maxMin) {
        if(depth == nums.length) {
            if(temp > maxMin[0])    maxMin[0] = temp;
            if(temp < maxMin[1])    maxMin[1] = temp;
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            if(op[i] > 0) {
                op[i]--;
                switch(i) {
                    case 0:
                        //temp += nums[depth];
                        dfs(depth + 1, temp + nums[depth], nums, op, maxMin);
                        break;
                    case 1:
                        //temp -= nums[depth];
                        dfs(depth + 1, temp - nums[depth], nums, op, maxMin);
                        break;
                    case 2:
                        //temp *= nums[depth];
                        dfs(depth + 1, temp * nums[depth], nums, op, maxMin);
                        break;
                    case 3:
                        //temp /= nums[depth];
                        dfs(depth + 1, temp / nums[depth], nums, op, maxMin);
                }
                op[i]++;
            }
        }
    }
}