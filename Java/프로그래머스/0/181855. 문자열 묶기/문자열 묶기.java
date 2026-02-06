import java.util.*;

class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] group = new int[30];
        for(String s : strArr) {
            group[s.length() - 1]++;
        }
        answer = Arrays.stream(group).max().orElse(0);
        return answer;
    }
}