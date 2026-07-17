class Solution {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0){
            int cur = storey % 10;
            int next = (storey / 10) % 10;
            
            if(cur > 5){
                answer += 10 - cur;
                storey += 10;
            }else if(cur == 5){
                if(next >= 5){
                    answer += 10 - cur;
                    storey += 10;
                }else{
                    answer += cur;
                }
            }else{
                answer += cur;
            }
            storey /= 10;
        }
        return answer;
    }
}
