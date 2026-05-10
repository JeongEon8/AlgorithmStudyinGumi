class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey>0){
            int mod = storey%10;
            storey/=10;
            if(mod>5){
                answer+=10-mod;
                storey++;
            }else if(mod<5){
                answer += mod;
            }else{
                answer+=5;
                if(storey%10>=5){
                  storey++;   
                }
            } 
        }
        return answer;
    }
}