import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ_5014 {

	static int[] arr;
//	static int count;
	static String msg = "use the stairs";
	static int f, s, g, u, d;
	static int[] button = new int[2];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		f = sc.nextInt();
		s = sc.nextInt();
		g = sc.nextInt();
		u = sc.nextInt();
		d = sc.nextInt();

		arr = new int[f + 1];
		button[0] = u;
		button[1] = -d;
//		count = 0;
		move(s); // start

		System.out.println();
	}

	private static void move(int start) {
		// TODO Auto-generated method stub

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visit = new boolean[f + 1];

		queue.add(start);
		visit[start] = true;
		arr[start] = 0;

		while (!queue.isEmpty()) {
			int now = queue.poll();

			if (now == g) {
//			return Integer.toString(count); 이렇게 하는 게 아닐 것 같음
				System.out.println(arr[now]);
				return;
			}

			for (int i = 0; i < 2; i++) {
				int next = now + button[i];

				if (next < 1 || next > f)
					continue;

				if (!visit[next]) {
					visit[next] = true;
					queue.add(next);
					arr[next] = arr[now] + 1;
				}
			}

		}

		System.out.println("use the stairs");
	}

}
