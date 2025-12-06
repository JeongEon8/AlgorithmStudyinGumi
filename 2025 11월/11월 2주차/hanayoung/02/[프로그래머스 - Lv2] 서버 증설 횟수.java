import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> server = new LinkedList<>();
        int size = 1;
        for(int i = 0; i < players.length; i++) {
            // i로 현재 시간 파악하기
            while(server.size() > 0 && server.peek() < i) {
                size--;
                server.poll();
            }
            if(players[i] < size*m) continue;
            while(players[i] >= size*m) {
                size++;
                server.add(i+k-1);
                answer++;
            }
        }
        return answer;
    }
}
