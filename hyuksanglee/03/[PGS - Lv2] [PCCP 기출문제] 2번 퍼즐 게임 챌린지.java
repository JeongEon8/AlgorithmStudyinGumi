class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int start = 1;
        int end =0;
        for( int diff : diffs){
            if( end<diff){
                end = diff;
            }
        }
        end+=1;
        
        while(start<=end){
            int min = (start+end)/2;
            long current = 0;
            int type = 0;
            
            for(int i = 0; i<diffs.length; i++){
                int diff = diffs[i];
                int time = times[i];
                int pre = 0;
                if(i !=0){
                    pre = times[i-1];
                }
                current += step(min, diff, time, pre);
                if(current>limit){
                    type =1;
                    break;
                }
            }
            if(type ==1 || current>limit){
                start = min +1;
                
                
            }else{
                answer = min;
                end = min-1;
                
            }
            
        }
        
        return answer;
    }
    
    public long step(int level, int diff, int time, int current){
        if(level>=diff){
            return time;
        }
        long count = diff-level;
        long solved = (long)(current+time)*count + time;
        return solved;
        
    }
}
