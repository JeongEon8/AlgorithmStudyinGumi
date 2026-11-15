class Solution {
    public int[] solution(long n) {
        int len = String.valueOf(n).length();
        int[] answer = new int[len];
        for(int i = 0; i<len; i++){
            answer[i] = (int) (n%10);
            n /= 10;
        }
        return answer;
    }
}