class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        // 문자열이 짝수일 때
        if(s.length()%2==0){
            idx = s.length()/2 -1;
            answer = ""+s.charAt(idx)+s.charAt(idx+1);
        }
        // 문자열이 홀수일 때
        else{
            idx = s.length()/2;
            answer = ""+s.charAt(idx);
        }
        return answer;
    }
}
