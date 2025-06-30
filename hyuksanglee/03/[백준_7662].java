package beakjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Baekjoon7662 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for(int t = 0; t<T; t++) {
			int K = Integer.parseInt(in.readLine());
			
			PriorityQueue<Integer> minQue = new PriorityQueue<>();
            PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> countMap = new HashMap<>();
            
			
			
			for(int k = 0; k<K; k++) {
				String[] input = in.readLine().split(" ");
				String comment = input[0];
				int num = Integer.parseInt(input[1]);
				
				if(comment.contains( "I")) {
					minQue.offer(num);
                    maxQue.offer(num);
					countMap.put(num, countMap.getOrDefault(num, 0) + 1);
				
				}
				
				if(comment.contains("D")) {
					 if (countMap.isEmpty()) continue;

	                    if (num == 1) remove(maxQue, countMap);
	                    else remove(minQue, countMap);
					
				}
				
			}
			
			clean(minQue, countMap);
            clean(maxQue, countMap);
			
			if (countMap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(maxQue.peek() + " " + minQue.peek());
            }
			
			
			
		}
	}
	
	
	static void remove(PriorityQueue<Integer> que, Map<Integer, Integer> map) {
        while (!que.isEmpty()) {
            int val = que.poll();
            if (map.containsKey(val)) {
                map.put(val, map.get(val) - 1);
                if (map.get(val) == 0) map.remove(val);
                break;
            }
        }
    }
	
	static void clean(PriorityQueue<Integer> que, Map<Integer, Integer> map) {
        while (!que.isEmpty() && !map.containsKey(que.peek())) {
			que.poll();
        }
    }

}
