class Solution {
    public int solution(int number) {
        int answer = 0;
        long num = number;
        
        while (num!=1) {
            if (num%2==0) {
                num = num/2;
                answer++;
            } else {
                num = 3*num + 1;
                answer++;
            }

            if (answer==500) return -1;
        }
        
        return answer;
    }
}
