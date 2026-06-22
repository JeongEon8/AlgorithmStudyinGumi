import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        Arrays.sort(book_time, (t1, t2) -> t1[0].equals(t2[0]) ? t1[1].compareTo(t2[1]) : t1[0].compareTo(t2[0]));
        
        PriorityQueue<Integer> que = new PriorityQueue<>();
        
        for (String[] time : book_time) {
            
            int start = changeTime(time[0]);
            int end = changeTime(time[1]) + 10;
            
            if (!que.isEmpty() && que.peek() <= start) {
                que.poll();
            }
            
            que.add(end);
        }
        
        return que.size();
    }
    
    private int changeTime(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
