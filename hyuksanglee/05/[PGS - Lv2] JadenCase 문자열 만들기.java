class Solution {
    public String solution(String s) {
        int type =1;
        String answer = "";
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(type==1&&  c !=' '){
                type = 0;
                if(c>='a'&& c<='z'){
                    c+='A'-'a';
                }
                
            }
            else {
                if(c == ' '){
                    type =1;
                } else{ 
                     if(c>='A'&& c<='Z'){
                    c+='a'-'A';
                }
                }
            }
            answer+=c;
        }
        
        return answer;
    }
}
