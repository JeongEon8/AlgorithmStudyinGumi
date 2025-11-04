import java.util.*;

class Solution {

    public int[] solution(String[] operations) {

        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < operations.length; i++) {
            String[] split = operations[i].split(" ");
            int num = Integer.parseInt(split[1]);

            if (split[0].equals("I")) {
                min.offer(num);
                max.offer(num);
            } else if (split[0].equals("D")) {
                if (min.isEmpty() || max.isEmpty())
                    continue;

                if (num == 1) { // 최댓값 제거
                    int v = max.poll();
                    min.remove(v);
                } else if (num == -1) {
                    int v = min.poll();
                    max.remove(v);
                }
            }
        }

        if (min.isEmpty()) {
            return new int[] { 0, 0 };
        }

        return new int[] { max.peek(), min.peek() };
    }
}