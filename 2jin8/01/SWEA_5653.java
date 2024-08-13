import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_5653 {

	static int N, M, K, total;
	static HashSet<String> visited = new HashSet<String>();
	static PriorityQueue<Cell> pq = new PriorityQueue<>();
	static HashSet<String> liveCell = new HashSet<String>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			total = 0;
			visited.clear();
			pq.clear();
			liveCell.clear();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					int life = Integer.parseInt(st.nextToken());
					if (life != 0) {
						pq.offer(new Cell(i, j, life, life, life * 2));
						visited.add(i + "," + j);
					}
				}
			}
			bfs();
			while (!pq.isEmpty()) {
				Cell cell = pq.poll();
				if (cell.die > K) { // K시간 이후에 살아있는 줄기 세포만 세기(K시간에 죽는 것은 포함  X)
					liveCell.add(cell.x + "," + cell.y);
				}
			}
			sb.append("#").append(t).append(" ").append(liveCell.size()).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs() {
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };
		for (int i = 1; i < K; i++) {
			while (!pq.isEmpty()) {
				Cell cell = pq.poll();
				// 활성화되는 시간이 현재 시간 이후라면 다음 시간으로 넘어가야 함
				if (cell.activity > i) {
					pq.offer(cell);
					break;
				}
				
				// 활성화 되는 시간이 현재 시간이라면
				if (cell.activity == i) {
					// 다음 시간에 네 방향으로 퍼짐
					for (int j = 0; j < 4; j++) {
						int nx = cell.x + dx[j];
						int ny = cell.y + dy[j];

						String pos = nx + "," + ny;
						// 해당 위치를 방문하지 않은 경우(= 포함되지 않음)
						if (!visited.contains(pos)) {
							visited.add(pos);
							pq.offer(new Cell(nx, ny, cell.life, i + 1 + cell.life, i + 1 + cell.life * 2));
						}
					}
					
					if (cell.die > K) {
						liveCell.add(cell.x + "," + cell.y);
					}
				}
			}
		}
	}

	static class Cell implements Comparable<Cell> {
		int x, y; // 줄기 세포의 위치
		int life; // 생명력
		int activity; // 활성화되는 시간
		int die; // 죽는 시간

		public Cell(int x, int y, int life, int activity, int die) {
			this.x = x;
			this.y = y;
			this.life = life;
			this.activity = activity;
			this.die = die;
		}

		@Override
		public int compareTo(Cell o) {
			if (this.activity == o.activity) // 활성화 시간이 같다면
				return -(this.life - o.life); // 생명력 시간을 기준으로 내림차순 정렬
			return this.activity - o.activity; // 활성화 시간을 기준으로 오름차순 정렬
		}
	}
}
