import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0) return cities.length * 5;
        int answer = 0;
        List<String> list = new ArrayList<>();
        for(String city: cities){
            city = city.toLowerCase();
            if(list.remove(city)){
                answer += 1;
            }else{
                if(list.size() >= cacheSize){
                    list.remove(0);
                }
                answer += 5;
            }
            list.add(city);
        }
        return answer;
    }
}