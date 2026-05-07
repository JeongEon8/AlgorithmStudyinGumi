import java.util.*;

class Solution {
    
    static class Job implements Comparable<Job>{
        int idx, reqTime, workTime;
        
        Job(int idx, int reqTime, int workTime) {
            this.idx = idx;
            this.reqTime = reqTime;
            this.workTime = workTime;
        }
        
        @Override
        public int compareTo(Job o) {
            // 요청 시간이 짧은 것
            if (o.workTime != this.workTime) {
                return this.workTime - o.workTime;
            } 
            
            if (o.reqTime != this.reqTime) {
                // 요청 시간이 빠른 것
                return this.reqTime - o.reqTime;
            }
            return this.idx - o.idx;
        }
        
    }
    public int solution(int[][] jobs) {
        int answer = 0;
        
        // 요청 시간 기준 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Job> pq = new PriorityQueue<>();
        
        int time = 0;
        int idx = 0;
        int total = 0;
        int count = 0;

        while (count < jobs.length) {

            // 현재 시간까지 요청된 작업들을 큐에 넣기
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.offer(new Job(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            // 실행 가능한 작업이 있는 경우
            if (!pq.isEmpty()) {

                Job cur = pq.poll();
                time += cur.workTime;
                total += (time - cur.reqTime);
                count++;
            }
            // 실행 가능한 작업이 없는 경우
            else {
                time = jobs[idx][0];
            }
        }

        return total / jobs.length;
    }
}