import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_5014 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");
		int F = Integer.parseInt(inputs[0]); // 총 건물 층수
		int S = Integer.parseInt(inputs[1]); // 현재 층
		int G = Integer.parseInt(inputs[2]); // 목표 층수
		int U = Integer.parseInt(inputs[3]); // 위로 이동 칸수
		int D = Integer.parseInt(inputs[4]); // 아래로 이동 칸수
		boolean[] visited = new boolean[F + 1]; // 0은 쓰지말자
		Queue<Integer> queue = new ArrayDeque<Integer>();
		queue.add(S);
		visited[S] = true;

		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int currentFloor = queue.poll();

				if (currentFloor == G) {
					System.out.println(count);
					return;
				}

				int upFloor = currentFloor + U;
				int downFloor = currentFloor - D;
				if (upFloor > 0 && upFloor <= F && !visited[upFloor]) {
					queue.add(upFloor);
					visited[upFloor] = true;
				}
				if (downFloor > 0 && downFloor <= F && !visited[downFloor]) {
					queue.add(downFloor);
					visited[downFloor] = true;
				}
			}
			count++;
		}
		System.out.println("use the stairs");
	}
}