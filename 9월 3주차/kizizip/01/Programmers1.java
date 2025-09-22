import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        
        int h = 1;
        int w = 1;
        for (int i=1; i<brown; i++) {
            // i가 가로길이라고 가정하고...
            w = i;
            h = (brown-4)/2 - w;
            
            if (w * h == yellow) break;
        }

      //생각해보니 앞에서 가로세로를 정할 필요가 없었다;
        int[] answer = {Math.max(w+2, h+2), Math.min(w+2, h+2)};
        
        return answer;
    }
}
