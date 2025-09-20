
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
			return a[1] - b[1]; // 컵라면이 작은 수부터
		});

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split(" ");
			arr[i][0] = Integer.parseInt(split[0]); // 데드라인
			arr[i][1] = Integer.parseInt(split[1]); // 컵라면 수

		}

		Arrays.sort(arr, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) { // 데드라인이 같으면
					return o2[1] - o1[1]; // 컵라면은 큰 수부터
				} else {
					return o1[0] - o2[0]; // 데드라인은 작은 수부터 정렬
				}
			}
		});

		for (int i = 0; i < N; i++) {
			 if (arr[i][0] > pq.size()) {
				// 데드라인이 size보다 크면 들어올수 잇다?
				pq.offer(new int[] { arr[i][0], arr[i][1] });
			} else if (arr[i][0]== pq.size() && pq.peek()[1] < arr[i][1]) {
				pq.remove();
				pq.offer(new int[] { arr[i][0], arr[i][1] });
			}
		}
		
		int ramen = 0;
		for(int[] p: pq) {
			ramen += p[1];
		}
		System.out.println(ramen);
	}

}


