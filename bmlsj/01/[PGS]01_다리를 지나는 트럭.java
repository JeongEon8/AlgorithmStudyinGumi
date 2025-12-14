import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
		int time = 0;
		int current_weight = 0;
		int idx = 0;

		for (int i = 0; i < bridge_length; i++) {
		    bridge.add(0);
		}

		
		while (idx < truck_weights.length || current_weight > 0) {

			time++;
			int leaving = bridge.poll();
			current_weight -= leaving;
			
			if (idx < truck_weights.length && current_weight + truck_weights[idx] <= weight) {
				bridge.add(truck_weights[idx]);
				current_weight += truck_weights[idx];
				idx++;
			} else {
				bridge.add(0);
			}
			

		}

		return time;
    }
}
