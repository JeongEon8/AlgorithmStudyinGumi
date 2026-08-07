class Solution {
    public long solution(int price, int money, int count) {
        long answer = -1;
        // 이용료 price
        // 몇 번 탔는지 count
        // 내 돈 money
        // N번 탔을 때 이용료 total
        long total = 0;
        for(int i = 1; i <= count; i ++){
            total += price *i;
        }
        if(total <= money){
            answer = 0;
        }
        else answer = total - money;
        

        return answer;
    }
}
