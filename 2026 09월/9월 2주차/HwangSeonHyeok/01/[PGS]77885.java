class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        for(int i= 0; i<numbers.length; i++){
            long current = numbers[i];
            if(current%2==0){
                answer[i] = current+1;
            }else{
                String binary = "0"+Long.toBinaryString(current);
                int lastZero = binary.lastIndexOf("0");
                String ans = binary.substring(0,lastZero)+"10"+binary.substring(lastZero+2);
                answer[i] = Long.parseLong(ans,2);
            }
        }
        return answer;
    }
}