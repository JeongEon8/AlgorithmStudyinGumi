import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int end = citations.length-1;
        
        int index =1;
        for(int i = end; i>=0; i--){
            
           int num = citations[i];
            if(num<index){
                return index-1;
            }
                index++;
        }
        
       
        
        return citations.length;
    }
}
