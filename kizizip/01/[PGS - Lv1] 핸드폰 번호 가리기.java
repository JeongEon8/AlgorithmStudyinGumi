class Solution {
    public String solution(String phone_number) {
        int mask = phone_number.length() - 4;
        
        if (mask > 0) {
            String answer = "*".repeat(mask) + phone_number.substring(mask);
            return answer; 
        } else return phone_number;
        
    }
}
