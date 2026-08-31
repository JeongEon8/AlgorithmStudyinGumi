class Solution {
    public int solution(String t, String p) {
        int length = t.length() - p.length() + 1;
        long pNum = Long.parseLong(p);
        int answer = 0;
        
        for (int i = 0; i < length; i++) {
            String temp = t.substring(i, i + p.length());   
            
            if (Long.parseLong(temp) <= pNum) {
            	answer++;
            }
        }
        return answer;
    }
}
