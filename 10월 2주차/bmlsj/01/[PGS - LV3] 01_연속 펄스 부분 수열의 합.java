class Solution {
    public long solution(int[] sequence) {
        long sum = 0;
        long max = 0, min = 0;

        for (int i = 0; i < sequence.length; i++) {
            int pulse = (i % 2 == 0) ? 1 : -1;
            sum += (long) sequence[i] * pulse;

            max = Math.max(max, sum);
            min = Math.min(min, sum);
        }

        return max - min;
    }
}