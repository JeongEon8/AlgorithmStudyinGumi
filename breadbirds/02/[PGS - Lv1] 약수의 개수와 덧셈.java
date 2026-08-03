class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++){
            int cnt = 0;
            // 약수의 갯수가 짝수 어케구함
            for(int j = 1; j <= i; j++){
                if(i%j == 0){
                    cnt++;
                }
            }
            if(cnt%2 == 0){
                answer = answer+i;
            }
            else{
                answer = answer-i;
            }
            cnt =0;
        }
        return answer;
    }
}
