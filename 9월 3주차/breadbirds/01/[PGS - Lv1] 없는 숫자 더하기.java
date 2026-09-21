class Solution {
    public int solution(int[] numbers) {
        int answer = 45; // 0부터 9까지의 합

        for (int number : numbers) {
            answer -= number;
        }

        return answer;
    }
}
