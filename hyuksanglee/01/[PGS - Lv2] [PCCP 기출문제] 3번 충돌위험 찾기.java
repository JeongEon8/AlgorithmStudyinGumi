
import java.util.*;

class Solution {

    static int[][] points;

    public int solution(int[][] points, int[][] routes) {
        this.points = points;
        int answer = 0;

        List<Queue<int[]>> robots = new ArrayList<>();

        for (int[] route : routes) {
            robots.add(find(route));
        }

        
    while (true) {
        int[][] arr = new int[101][101];
        boolean moved = false;

        for (Queue<int[]> robot : robots) {
            if (robot.isEmpty()) {
                continue;
            }

            moved = true;

            int[] pos = robot.poll();
            int r = pos[0];
            int c = pos[1];

            arr[r][c]++;

            if (arr[r][c] == 2) {
                answer++;
            }
        }

        if (!moved) {
            break;
        }
    }


        return answer;
    }

    static Queue<int[]> find(int[] route) {
        Queue<int[]> queue = new LinkedList<>();

        int pre = route[0] - 1;

        int pr = points[pre][0];
        int pc = points[pre][1];

        queue.offer(new int[]{pr, pc});

        for (int i = 1; i < route.length; i++) {
            int next = route[i] - 1;

            int nr = points[next][0];
            int nc = points[next][1];

            while (pr != nr) {
                pr += (pr < nr) ? 1 : -1;
                queue.offer(new int[]{pr, pc});
            }

            while (pc != nc) {
                pc += (pc < nc) ? 1 : -1;
                queue.offer(new int[]{pr, pc});
            }
        }

        return queue;
    }
}
