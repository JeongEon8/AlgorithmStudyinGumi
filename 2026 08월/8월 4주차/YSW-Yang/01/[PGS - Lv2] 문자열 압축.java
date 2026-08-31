class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= (s.length() / 2); i++){
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);
            int count = 1;
            
            for(int j = i; j < s.length(); j += i){
                int end = Math.min(j + i, s.length());
                String sub = s.substring(j, end);
                if(prev.equals(sub)){
                    count++;
                }else{
                    if(count > 1){
                        sb.append(count);
                    }
                    sb.append(prev);
                    
                    prev = sub;
                    count = 1;
                }
            }
            if(count > 1){
                sb.append(count);
            }
            sb.append(prev);
            
            answer = Math.min(answer, sb.length());
        }
        
        return answer;
    }
}
