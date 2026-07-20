class Solution {
    public long solution(int price, int money, int count) {
        
        long need = 0;
        for (int i = 1; i<=count; i++) {
            need += price*i;
        }

        return need-money > 0 ? need-money : 0;
    }
}
