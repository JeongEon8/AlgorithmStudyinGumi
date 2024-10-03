import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961 {

	static int N, d, k, c; // d: 초밥 가짓수, k: 연속해서 먹는 접시의 수, c: 쿠폰 번호
	static int[] arr, visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[N];
		visited = new int[d + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		getMaxKind();
	}

	static void getMaxKind() {
		int kind = 0;

		// 초기값 넣기
		for (int i = 0; i < k; i++) {
			if (visited[arr[i]]++ == 0)
				kind++;
		}

		int maxKind = kind;
		// 각 위치를 기준으로 연속한 k개의 접시 확인하기
		for (int i = 0; i < N; i++) {
			// 제거한 값이 더 이상 list에 있지 않다면 1 감소
			if (--visited[arr[i]] == 0)
				kind--;

			int end = (i + k) % N;
			// 추가하려는 값이 처음으로 등록되는 것이면 1 증가
			if (visited[arr[end]]++ == 0)
				kind++;

			maxKind = Math.max(maxKind, visited[c] == 0 ? kind + 1 : kind);
		}
		System.out.println(maxKind);
	}
}
