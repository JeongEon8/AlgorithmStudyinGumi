import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_2644 {

	static int[] arr; // 노드에 대한 거리 저장할 배열
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // 그래프를 저장할 리스트

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		arr = new int[n + 1]; // 각 노드까지의 거리를 저장할 배열
		visit = new boolean[n + 1]; // 각 노드의 방문 여부를 저장할 배열
		int a = sc.nextInt();
		int b = sc.nextInt();

		// 그래프 초기화 (1부터 n까지의 노드)
		for (int i = 0; i <= n; i++)
			list.add(new ArrayList<>());

		int m = sc.nextInt();

		// 간선 정보를 그래프에 추가하기
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			list.get(x).add(y);
			list.get(y).add(x);
		}

		System.out.println(find(a, b));

	}

	private static int find(int start, int end) {
		// TODO Auto-generated method stub
		Queue<Integer> queue = new LinkedList<>();
		arr[start] = 0; // 시작노드의 거리 0
		visit[start] = true;

		queue.offer(start);

		while (!queue.isEmpty()) {
			int now = queue.poll();

			for (int next : list.get(now)) { // 현재 노드의 모든 인접 노드에 대해 반복
				if (!visit[next]) {
					arr[next] = arr[now] + 1; // 인접 노드의 거리를 현재 노드의 거리 + 1로 설정
					if (next == end) // 인접 노드가 목표 노드인 경우, 거리 반환
						return arr[next];
					queue.offer(next); // 인접 노드를 큐에 추가
					visit[next] = true; // 인접 노드를 방문한 것으로 표시
				}
			}
		}
		return -1; // 목표 노드에 도달할 수 없는 경우 -1 반환
	}

}
