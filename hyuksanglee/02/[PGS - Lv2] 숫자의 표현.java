class Solution {
    public int solution(int n) {
        int answer = 0;
        int total = 0;
        int index = 1;
        for(int i = 1; i<=n; i++){
            total+= i;
            while(total>n){
                total -= index;
                index++;
            }
            if(total ==n){
                answer++;
            }
        }
        return answer;
    }
}
