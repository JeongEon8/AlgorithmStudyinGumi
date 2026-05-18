import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int size:tangerine){
            map.put(size, map.getOrDefault(size,0)+1);
        }
        List<Integer> counts = new ArrayList(map.values());
        Collections.sort(counts,Collections.reverseOrder());
        int current = 0;
        for(int count: counts){
            current+=count;
            answer++;
            if(current>=k)break;
        }
        return answer;
    }
}