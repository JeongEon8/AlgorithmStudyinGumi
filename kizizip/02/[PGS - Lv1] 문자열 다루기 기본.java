class Solution {
    public boolean solution(String s) {
        
        if (s.length() == 4 || s.length() == 6) {
            if (s.matches("\\d+")) return true;
        }
        
        return false;
    }
}
