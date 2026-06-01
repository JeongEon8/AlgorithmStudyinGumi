class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        
        int sum = 0;
        
        sum += x/10000;
        sum += (x%10000)/1000;
        sum += (x%1000)/100;
        sum += (x%100)/10;
        sum += (x%10);
        
        if (x % sum != 0) answer = false;
        
        return answer;
    }
}
