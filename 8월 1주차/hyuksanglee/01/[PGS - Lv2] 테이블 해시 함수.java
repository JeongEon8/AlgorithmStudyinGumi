import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        int targetCol = col - 1;
        Arrays.sort(data, (a, b) -> {
            if(a[targetCol] != b[targetCol]){
               return Integer.compare(a[targetCol], b[targetCol]);
            }
        return Integer.compare(b[0], a[0]);
        });
        
        
        for(int i = row_begin-1; i<row_end; i++){
            int[] arr = data[i];
            int total = 0;
            for(int j = 0; j<arr.length; j++){
                total+= arr[j] % (i+1);
            }
            answer ^= total;
        }
        return answer;     
    }
   
}
    
    
