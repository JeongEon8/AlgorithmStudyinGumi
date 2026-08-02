class Solution {
    public String solution(String s) {
        String answer = "";
        boolean isFirst = true;
        for(char c : s.toCharArray()){
            if(c==' '){
                answer += c;
                isFirst = true;
            }else{
                if(isFirst){
                    isFirst = false;
                    answer+= Character.toUpperCase(c);
                }else{
                    answer+= Character.toLowerCase(c);
                }
            }
        }
        
        
        return answer;
    }
}