import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Set<String> cacheTable = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        
        if(cacheSize == 0){
            return cities.length * 5;
        }
        
        for(String city : cities){
            city = city.toLowerCase();
            
            if(cacheTable.contains(city)){
                queue.remove(city);
                queue.add(city);
                
                answer++;
            }else{
                if(queue.size() == cacheSize){
                    cacheTable.remove(queue.poll());
                }
                cacheTable.add(city);
                queue.add(city);
                
                answer += 5;
            }
        }
        
        return answer;
    }
}
