class Solution {
    public String solution(String s) {
        String answer = "";
        String [] string = s.split(" ");
        int max = -9999;
        int min = 9999;
        for(int i = 0; i < string.length; i++){
            max = Math.max(Integer.parseInt(string[i]), max);
            min = Math.min(Integer.parseInt(string[i]), min);
        }
        
        answer = min + " " + max;
        return answer;
    }
}
