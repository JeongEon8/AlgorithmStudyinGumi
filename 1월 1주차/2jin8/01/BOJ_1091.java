import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1091 {

	static int N;
	static int[] P, S;
	static int[] cards, origin;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		P = new int[N]; // i번 카드는 플레이어 P[i]에게 나눠줘야 함
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
		}

		S = new int[N]; // 카드를 섞는 방법
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}

		origin = new int[N];
		cards = new int[N];
		for (int i = 0; i < N; i++) {
			cards[i] = i;
			origin[i] = i;
		}
		System.out.println(shuffle());
	}

	static int shuffle() {
		int cnt = 0;
		while (true) { 
			// 원본 배열로 돌아오면 종료
			if (cnt > 0 && eqaulOrigin())  break;
			
			// 해당 플레이어에게 정해진 카드를 줄 수 있는지 확인하기
			if (check()) return cnt;

			// 카드 섞기
			int[] shuffleCards = new int[N];
			for (int i = 0; i < N; i++) {
				shuffleCards[S[i]] = cards[i];
			}
			cards = shuffleCards.clone();
			cnt++;
		}
		return -1;
	}

	static boolean check() {
		for (int i = 0; i < N; i++) {
			int card = cards[i]; // 현재 카드
			int player = i % 3; // 현재 카드를 나누줄 플레이어
			// i번 카드를 플레이어 P[i]에게 나눠주지 못하는 경우라면 false
			if (P[card] != player)
				return false;
		}
		return true;
	}

	// 원본 배열이랑 같아지면 그 이후에 계속 섞어도 의미없음
	static boolean eqaulOrigin() {
		for (int i = 0; i < N; i++) {
			if (origin[i] != cards[i])
				return false;
		}
		return true;
	}
}
