class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for (int len = 1; len <= s.length() / 2; len++) {
            String prev = s.substring(0, len);
            int cnt = 1;
            int tmp = 0;
            
            for (int i = len; i < s.length(); i += len) {
                int end = Math.min(i + len, s.length());
                String cur = s.substring(i, end);
                
                if (cur.equals(prev)) {
                    cnt++;
                } 
                else {
                    if (cnt > 1)
                        tmp += String.valueOf(cnt).length();
                    
                    tmp += prev.length();
                    prev = cur;
                    cnt = 1;
                }
            }
            if (cnt > 1)
                tmp += String.valueOf(cnt).length();
            
            tmp += prev.length();
            answer = Math.min(answer, tmp);
        }
        
        return answer;
    }
}
