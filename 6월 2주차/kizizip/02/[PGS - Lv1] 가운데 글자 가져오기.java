class Solution {
    public String solution(String s) {
        int mid = s.length()/2;
        
        if (s.length()%2 == 0) {
            return "" + s.charAt(mid - 1) + s.charAt(mid);
        } else {
            return String.valueOf(s.charAt(mid));
        }
        
    }
}
