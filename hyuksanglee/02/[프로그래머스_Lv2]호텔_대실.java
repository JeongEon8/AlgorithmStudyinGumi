package programmers;

import java.util.*;

public class Pragrammers_호텔_대실 {

	public static int main(String[] args, String[][] book_time) {
		
		 
			    
	        Arrays.sort(book_time, (a, b) -> {
	            int s1 = toMinute(a[0]);
	            int s2 = toMinute(b[0]);
	            if (s1 != s2) return s1 - s2;
	            int e1 = toMinute(a[1]);
	            int e2 = toMinute(b[1]);
	            return e1 - e2;
	        });

	        PriorityQueue<Integer> que = new PriorityQueue<>();

	        int answer = 0;

	        for (String[] booking : book_time) {
	            int start = toMinute(booking[0]);
	            int end = toMinute(booking[1]) + 10; 

	           
	            if (!que.isEmpty() && que.peek() <= start) {
	                que.poll();
	            }

	            que.add(end);

	            answer = Math.max(answer, que.size());
	        }

	        return answer;
	    }
	    

	    static public int toMinute(String time) {
	        int h = Integer.parseInt(time.substring(0, 2));
	        int m = Integer.parseInt(time.substring(3, 5));
	        return h * 60 + m;
	    }

}


