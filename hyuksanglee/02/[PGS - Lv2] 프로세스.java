
import java.util.*;

class Solution {
    static class Info {
        int index;
        int price;

        Info(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Info> queue = new LinkedList<>();

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Info(i, priorities[i]));
            pq.offer(priorities[i]);
        }

        while (!queue.isEmpty()) {
            Info info = queue.poll();

            if (info.price < pq.peek()) {
                queue.offer(info);
                continue;
            }

            pq.poll();
            answer++;

            if (info.index == location) {
                return answer;
            }
        }

        return answer;
    }
}
