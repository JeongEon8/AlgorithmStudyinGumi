import java.util.*;
class Solution {
    public int solution(String s) {
        
        if (s.length() == 1) return 1;
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= s.length() / 2; i++) {
            answer = Math.min(answer, comp(i, s));
        }
        
        return answer;
    }
    
    static int comp(int cnt, String s) {
        List<String> chunks = new ArrayList<>();
        
        // 자르기
        for(int i = 0; i < s.length(); i += cnt) {
            int end = Math.min(i + cnt, s.length());
            String chunk = s.substring(i, end);
            chunks.add(chunk);
        }
        
        // 문자 압축
        StringBuilder sb = new StringBuilder();
        String prev = chunks.get(0);
        int count = 1;
        
        for(int i = 1; i < chunks.size(); i++) {
            String curr = chunks.get(i);
            
            if (prev.equals(curr)) {
                count++;
            } else {
                if (count > 1) sb.append(count);
                sb.append(prev);
                
                prev = curr;
                count = 1;
            }
        }
        
        if (count > 1) sb.append(count);
        sb.append(prev);
        
        return sb.length();
    }
}