class Solution {
    public int[] solution(int brown, int yellow) {
        
        
        int total = (brown+4)/2;
        int x = 2;
        int y = total-x;
        
        int r = 0;
        int c = 0;
        
        while(y>1){
            int to = x * y;
            int result = to - brown;
            if(result == yellow){
                r = y;
                c = x;
                
                break;
            }
            x+=1;
            y = total - x;
        }
        
        int[] answer = {r, x};
        return answer;
    }
}
