import java.util.*;
class Solution {
    
    class Server{
        int count;
        int time;
        Server(int count, int time){
            this.count = count;
            this.time = time;
        }
    }
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Server> que = new ArrayDeque<Server>();
        int serverCount = 0;
        
        for(int cur = 0; cur<players.length; cur++){
            
            while(!que.isEmpty() && que.peek().time <= cur){
                Server info = que.poll();
                serverCount -= info.count;
            }
            
            int size = que.size();
            int player = players[cur];
           
            int need = player/m;
            if(need>serverCount){
                int buy = need-serverCount;
                que.add(new Server(buy, cur+k));
                answer += buy;
                serverCount += buy;
            }
            
            
            
        }
        
        return answer;
    }
}
