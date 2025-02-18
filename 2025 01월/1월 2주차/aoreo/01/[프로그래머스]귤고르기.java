import java.util.PriorityQueue;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        PriorityQueue<Tangerine> pQueue = new PriorityQueue<>();
        int[] tmp = new int[10000001];

        for (int tan : tangerine) {
            tmp[tan] += 1;
        }
        for(int i = 0; i < tmp.length; i++) {
            if(tmp[i] != 0) {
                pQueue.add(new Tangerine(i, tmp[i]));
            }
        }
        int boxCnt = 0;

        while(boxCnt < k) {
            Tangerine tan = pQueue.poll();
            boxCnt += tan.cnt;
            answer += 1;
        }
        
        return answer;
    }
    static class Tangerine implements Comparable<Tangerine>{
        int size;
        int cnt;

        public Tangerine(int size, int cnt) {
            this.size = size;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Tangerine o) {
          if(this.cnt < o.cnt) return 1;
          else return -1;
        }
    }
}
