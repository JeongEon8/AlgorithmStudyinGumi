import java.util.*;


class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Long> set = new HashSet();
        int len = elements.length;
        
        for(int i = 0; i<len; i++){
            long total =0;
            for(int j = 0; j<len; j++){
                total += elements[(i + j) % len];
                set.add(total);
            }
        }
        
        return set.size();
    }
}
