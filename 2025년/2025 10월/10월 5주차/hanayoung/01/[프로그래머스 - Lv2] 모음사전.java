import java.util.Map;
import java.util.HashMap;

class Solution {
    static Map<String, Integer> hashMap;
    static int order = 1;
    public int solution(String word) {
        int answer = 0;
        hashMap = new HashMap<>();
        makeOrder("", "AEIOU", 0);
        answer = hashMap.get(word);
        return answer;
    }
    
    public void makeOrder(String str, String word, int r) {
        if(r == 6) return;
        for(int i = 0; i < word.length(); i++) {
            if(str.length() > 0 && hashMap.get(str) == null) {
                hashMap.put(str, order);
                order++;
            }
            makeOrder(str+word.charAt(i), word, r+1);
        }
    }
}
