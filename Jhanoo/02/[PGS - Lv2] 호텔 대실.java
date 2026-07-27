import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[] timeline = new int[24 * 60 + 11];
        
        for (String[] book : book_time) {
            int start = convert(book[0]);
            int end = convert(book[1]) + 10;
            
            timeline[start]++;
            timeline[end]--;
        }
        
        int answer = 0;
        int rooms = 0;
        
        for (int i : timeline) {
            rooms += i;
            answer = Math.max(answer, rooms);
        }
        
        return answer;
    }
    
    private int convert(String time) {
        String[] hhmm = time.split(":");
        int hour = Integer.parseInt(hhmm[0]);
        int minute = Integer.parseInt(hhmm[1]);
        
        return hour * 60 + minute;
    }
}
