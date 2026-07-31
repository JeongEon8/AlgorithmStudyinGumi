import java.util.*;
class Solution {
    public class Server implements Comparable<Server>{
        int serverCount;
        int endTime;
        
        public Server(int serverCount, int endTime){
            this.serverCount = serverCount;
            this.endTime = endTime;
        }
        
        public int compareTo(Server other){
            return Integer.compare(this.endTime, other.endTime);
        }
    }
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        PriorityQueue<Server> pq = new PriorityQueue<>();
        
        int currentServerCount = 0;
        for(int i = 0; i < players.length; i++){
            if(!pq.isEmpty() && pq.peek().endTime == i){
                currentServerCount -= pq.poll().serverCount;
            }
            
            int needServerCount = players[i] / m - currentServerCount;
            if(needServerCount > 0){
                pq.add(new Server(needServerCount, i + k));
                currentServerCount += needServerCount;
                answer += needServerCount;
            }
            
        }
        
        return answer;
    }
}
