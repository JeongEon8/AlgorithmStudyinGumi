class Solution {
    public long[] solution(long[] numbers) {
        int N = numbers.length;
        long[] answer = new long[N];
        
        for(int i = 0; i < N; i++){
            long num = numbers[i];
            
            if(num % 2 == 0){
                answer[i] = num + 1;
            }else{
                long lastZero = ~num & (num + 1);
                answer[i] = (num | lastZero) & ~(lastZero >> 1);
            }
        }
        
        return answer;
    }
}
