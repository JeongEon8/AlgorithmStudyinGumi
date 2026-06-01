import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 65536;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        HashMap<String, Integer> str1HashMap = new HashMap<>();
        HashMap<String, Integer> str2HashMap = new HashMap<>();
        int count1 = 0;
        int count2 = 0;
        
        if(str1.equals(str2)){
            return answer;
        }
        
        for(int i = 0; i < str1.length() - 1; i++){
            if(str1.charAt(i) >= 'A' && str1.charAt(i) <= 'Z' && str1.charAt(i + 1) >= 'A' && str1.charAt(i + 1) <= 'Z'){
                str1HashMap.put(str1.charAt(i) + "" + str1.charAt(i + 1), str1HashMap.getOrDefault(str1.charAt(i) + "" + str1.charAt(i + 1), 0) + 1);
            }
        }
        
        for(int i = 0; i < str2.length() - 1; i++){
            if(str2.charAt(i) >= 'A' && str2.charAt(i) <= 'Z' && str2.charAt(i + 1) >= 'A' && str2.charAt(i + 1) <= 'Z'){
                str2HashMap.put(str2.charAt(i) + "" + str2.charAt(i + 1), str2HashMap.getOrDefault(str2.charAt(i) + "" + str2.charAt(i + 1), 0) + 1);
            }
        }
        
        for(String key : str1HashMap.keySet()){
            if(str2HashMap.containsKey(key)){
                count1 += Math.min(str1HashMap.get(key), str2HashMap.get(key)); 
            }else{
                count2 += str1HashMap.get(key);
            }
        }
        
        for(String key : str2HashMap.keySet()){
            if(str1HashMap.containsKey(key)){
                count2 += Math.max(str1HashMap.get(key), str2HashMap.get(key)); 
            }else{
                count2 += str2HashMap.get(key);
            }
        }
        
        answer = answer * count1 / count2;
        
        return answer;
    }
}
