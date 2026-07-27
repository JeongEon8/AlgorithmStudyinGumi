class Solution {
    public String solution(String s) {
        String answer = "";
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] str = s.split(" ");
        
        for(int i = 0; i<str.length; i++){
            int num = Integer.parseInt(str[i]);
            if(max < num){
                max = num;
            }
            if(min >num){
                min = num;
            }
        }
        
        answer+= min+" "+max;
        
        
        return answer;
    }
}
