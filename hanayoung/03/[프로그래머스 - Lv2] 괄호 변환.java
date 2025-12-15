class Solution {
    public String solution(String p) {
        String answer = "";
        answer = recur(p, answer);

        return answer;
    }
    
    public String recur(String p, String answer) {

        if(p.length() == 0) return answer;
        int left = 0, right = 0, index = 0;
        int sum = 0;
        boolean isRight = true;
        for(int i = 0; i < p.length(); i++) {
            if(p.charAt(i) == '(') {
                left++;
                sum -= 1;
            }
            else {
                right++;
                sum += 1;
            }
            if(sum > 0) isRight = false;
            if(left == right) {
                index = i;
                break;
            }
        }
        if(sum != 0) isRight = false;
        if(isRight == false) {
            answer += '(';
            answer = recur(p.substring(index+1), answer);
            answer += ')';
            String str = p.substring(1, index);
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) == '(') answer += ')';
                else answer += '(';
            }
        } else {
            answer = recur(p.substring(index+1), answer+p.substring(0, index+1));
        }
        return answer;
    }
}
