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
			
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> countMap = new HashMap<>();
            
			
			
			for(int k = 0; k<K; k++) {
				String[] input = in.readLine().split(" ");
				String comment = input[0];
				int num = Integer.parseInt(input[1]);
				
				if(comment.contains( "I")) {
					minHeap.offer(num);
                    maxHeap.offer(num);
					countMap.put(num, countMap.getOrDefault(num, 0) + 1);
				
				}
				
				if(comment.contains("D")) {
					 if (countMap.isEmpty()) continue;

	                    if (num == 1) remove(maxHeap, countMap);
	                    else remove(minHeap, countMap);
					
				}
				
			}
			
			clean(minHeap, countMap);
            clean(maxHeap, countMap);
			
			if (countMap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(maxHeap.peek() + " " + minHeap.peek());
            }
			
			
			
		}
	}
	
	
	static void remove(PriorityQueue<Integer> heap, Map<Integer, Integer> map) {
        while (!heap.isEmpty()) {
            int val = heap.poll();
            if (map.containsKey(val)) {
                map.put(val, map.get(val) - 1);
                if (map.get(val) == 0) map.remove(val);
                break;
            }
        }
    }
	
	static void clean(PriorityQueue<Integer> heap, Map<Integer, Integer> map) {
        while (!heap.isEmpty() && !map.containsKey(heap.peek())) {
            heap.poll();
        }
    }

}
