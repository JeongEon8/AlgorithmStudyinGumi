import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String,Integer>map = new HashMap<>();
        for(String [] clothe : clothes){
            if(map.get(clothe[1])==null){
                map.put(clothe[1],1);
            }else{
                map.put(clothe[1],map.get(clothe[1])+1);
            }
        }
        int answer = 1;
        for(String key : map.keySet()){
            answer*=(map.get(key)+1);
        }
        
        
        return --answer;
    }
}
