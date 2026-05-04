import java.util.*;

class Solution {
    class Info implements Comparable<Info>{
        int start;
        int end;
        
        public Info(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        @Override
        public int compareTo(Info other){
            return this.start - other.start;
        }
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        int N = book_time.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Info> list = new ArrayList<>(); 
        
        for(int i = 0; i < N; i++){
            String[] sTime = book_time[i][0].split(":");
            String[] eTime = book_time[i][1].split(":");
            
            int start = Integer.parseInt(sTime[0]) * 60 + Integer.parseInt(sTime[1]);
            int end = Integer.parseInt(eTime[0]) * 60 + Integer.parseInt(eTime[1]) + 10;
            
            list.add(new Info(start, end));
        }
        Collections.sort(list);
        
        for(int i = 0; i < N; i++){
            Info next = list.get(i);
            
            if(pq.isEmpty()){
                pq.add(next.end);
                answer++;
            }else{
                if(pq.peek() <= next.start){
                    pq.poll();
                    pq.add(next.end);
                }else{
                    pq.add(next.end);
                    answer++;
                }
            }
        }
        
        return answer;
    }
}