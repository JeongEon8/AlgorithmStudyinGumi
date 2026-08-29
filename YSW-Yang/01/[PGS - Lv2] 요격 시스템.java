import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        int lastMissile = 0;
        
        for(int[] target : targets){
            int start = target[0];
            int end = target[1];
            
            if(start >= lastMissile){
                answer++;
                lastMissile = end;
            }
        }
        
        return answer;
    }
}
