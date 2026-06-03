import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> m1 = makeMultiSet(str1);
        Map<String, Integer> m2 = makeMultiSet(str2);
        
        Set<String> keys = new HashSet<>();
        keys.addAll(m1.keySet());
        keys.addAll(m2.keySet());
        
        int intersection = 0;
        int union = 0;
        
        for (String key : keys) {
            int cnt1 = m1.getOrDefault(key, 0);
            int cnt2 = m2.getOrDefault(key, 0);
            
            intersection += Math.min(cnt1, cnt2);
            union += Math.max(cnt1, cnt2);
        }
        
        if (union == 0) {
            return 65536;
        }
        
        int answer = 65536 * intersection / union;
        return answer;
    }
    
    static Map<String, Integer> makeMultiSet(String str) {
        Map<String, Integer> map = new HashMap<>();
        str = str.toUpperCase();
        
        for (int i = 0; i < str.length() - 1; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(i + 1);
            
            
            if (c1 < 'A' || c1 > 'Z')
                continue;
            if (c2 < 'A' || c2 > 'Z')
                continue;
            
            String key = "" + c1 + c2;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        return map;
    }
}
