import java.util.*;
class Solution {
    boolean isCorrect(int[] number, int[] current){
        for(int i = 0; i<number.length; i++){
            if(number[i] != current[i])return false;
        }
        return true;
    }
    public int solution(String[] want, int[] number, String[] discount) {
        int ans = 0;
        int[] arr = new int[want.length];
        Map<String,Integer> mapper = new HashMap<>();
        for(int i = 0; i<want.length; i++){
            mapper.put(want[i],i);
        }
        for(int i = 0; i<10; i++){
            if(mapper.containsKey(discount[i]))
                arr[mapper.get(discount[i])]++;
        }
        if(isCorrect(number, arr)) ans++;
        for(int i = 1; i<discount.length-9; i++){
            if(mapper.containsKey(discount[i-1]))
                arr[mapper.get(discount[i-1])]--;
            if(mapper.containsKey(discount[i+9]))
                arr[mapper.get(discount[i+9])]++;
            if(isCorrect(number,arr)){
                ans++;
            }
        }
        return ans;
    }
    
}