class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        while(s.length()!=1){
            int prevLength = s.length();
            String one = s.replace("0","");
            int oneCnt = one.length();
            s = Integer.toBinaryString(oneCnt);
            answer[1] += prevLength- oneCnt;
            answer[0]++;
        }
        return answer;
    }
}
