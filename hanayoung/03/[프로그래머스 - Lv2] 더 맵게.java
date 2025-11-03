import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for(int s: scoville) {
            pQueue.add(s);
        }
        while(pQueue.peek() < K) {
            if(pQueue.size() < 2) {
                answer = -1;
                break;
            }
            int min = pQueue.poll();
            int next = pQueue.poll();
            pQueue.add(min+next*2);
            answer++;
        }
        return answer;
    }
}
