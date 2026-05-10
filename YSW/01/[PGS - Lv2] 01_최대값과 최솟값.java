class Solution {
    public String solution(String s) {
        String answer = "";
        String[] sArr = s.split(" ");
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < sArr.length; i++){
            int n = Integer.parseInt(sArr[i]);
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        answer += min + " " + max;
        
        return answer;
    }
}