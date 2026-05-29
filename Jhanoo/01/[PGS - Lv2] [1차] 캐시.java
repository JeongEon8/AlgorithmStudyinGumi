import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        LinkedList<String> cache = new LinkedList<>();
        
        if (cacheSize == 0)
            return cities.length * 5;
        
        int answer = 0;
        int size = 0;
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            
            // hit
            if (cache.contains(city)) {
                cache.remove(city);
                cache.add(city);
                answer++;
            }
            // miss
            else {
                if (cache.size() == cacheSize) {
                    cache.remove();
                }
                cache.add(city);
                answer += 5;
            }
        }
        
        
        return answer;
    }
}
