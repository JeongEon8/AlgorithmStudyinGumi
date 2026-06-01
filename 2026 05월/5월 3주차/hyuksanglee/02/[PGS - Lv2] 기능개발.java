import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<Integer>();
        
        int len = progresses.length;
        int min = 0;
        int count =0;
        int index = 0;
        for(int i = 0 ; i<len; i++){
            int progresse = progresses[i];
            int speed = speeds[i];
            int total = 100 - progresse;
            int result = total/speed; 
            if(total%speed >0) result += 1;
            if(i ==0){
                min = result;
                count++;
            }else{
                if(min< result){
                    min = result;
                    list.add(count);
                    count = 1;
                    index = i;
                }else{
                    count++;
                }
            }
            
        }
        
        if(index != len-1 || count ==1){
            list.add(count);
        }
        
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
