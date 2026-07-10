class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            if (num % 2 == 0) {
                answer[i] = num + 1;
            } else {
                // 앞에 0을 붙이고, 처음 나오는 0 찾기
                String bin = "0" + Long.toBinaryString(num);
                char[] chars = bin.toCharArray();
                
                int idx = bin.lastIndexOf("0");
                chars[idx] = '1';
                chars[idx + 1] = '0';
                
                answer[i] = Long.parseLong(new String(chars), 2);
            }
        }
        return answer;
    }
}