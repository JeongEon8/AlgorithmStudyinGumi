import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, (a, b) -> a[0].compareTo(b[0]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String[] time: book_time) {
            
            int start = convert(time[0]);
            int end = convert(time[1]) + 10;
            
            // 재사용 가능하면 poll()
            while(!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }

            pq.offer(end);
            answer = Math.max(answer, pq.size());
        
        }
        
        
        return answer;
    }
    
    static int convert(String time) {
        
        String[] t = time.split(":");
        
        int hour = Integer.parseInt(t[0]);
        int min = Integer.parseInt(t[1]);
        
        return hour * 60 + min;
    }
}