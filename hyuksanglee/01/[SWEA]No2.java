package S_2_승강제리그;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

class UserSolution {

	public static int N, L;

	public static Player[][] team;
	static List<Player>[] teamList;

	public static class Player implements Comparable<Player> {
		public int id;
		public int ability;

		@Override
		public int compareTo(Player o) {

			if (this.ability == o.ability) {
				return this.id - o.id;
			}
			return o.ability - this.ability;
		}

		@Override
		public String toString() {
			return id + " " + ability;
		}

	}

	public static int getN() {
		return N;
	}

	public static void setN(int n) {
		N = n;
	}

	public static int getL() {
		return L;
	}

	public static void setL(int l) {
		L = l;
	}

	public static void teamSort() {
		// 리그안에 선수들 능력별로 정렬
		for (int l = 0; l < L; l++) {
			Arrays.sort(team[l]);
		}
	}

	// 값을 추가 할때 크기에 맞게 추가
	public static void insertSort(int l, Player player) {
		int index = 0;
		for (Player p : teamList[l]) {
			if (p.ability > player.ability) {
				index++;
			} else if (p.ability == player.ability) {
				if (p.id < player.id) {
					index++;
				}
			} else {
				break;
			}
		}
		teamList[l].add(index, player);
	}

	void init(int N, int L, int mAbility[]) {
		setN(N);
		setL(L);
		team = new Player[L][N / L];
		teamList = new ArrayList[L];

		int index = 0;
		for (int l = 0; l < L; l++) {
			teamList[l] = new ArrayList<>();
			for (int n = 0; n < N / L; n++) {
				int id = index;
				int ability = mAbility[index++];
				Player player = new Player();
				player.id = id;
				player.ability = ability;
				if (teamList[l].isEmpty()) {
					teamList[l].add(player);
				} else {
					insertSort(l, player);
				}
			}

		}

//		// 선수 출력
//		for (int l = 0; l < L; l++) {
//			System.out.println(Arrays.toString(teamList[l].toArray()));
//		}

//		teamSort();

	}

	int move() {

		int total = 0;

		// 각 리그에 교환해야하는 선수들 담는 큐선언
		Queue<Player>[] moveList = new ArrayDeque[L];
		moveList[0] = new ArrayDeque<>();

		for (int l = 0; l < L - 1; l++) {
			moveList[l + 1] = new ArrayDeque<>();

			Player playerA = new Player();
			Player playerB = new Player();

			// 교환 해야하는 선수들 변수에 담기
			playerA = teamList[l].get(teamList[l].size() - 1);
			playerB = teamList[l + 1].get(0);

			// 교환할 선수 원래 리그에서 제거
			teamList[l].remove(teamList[l].size() - 1);
			teamList[l + 1].remove(0);

			// 교환할 선수의 id합하기
			total += playerA.id;
			total += playerB.id;

			// 교환 될 리그에 담는 큐에 해당 선수 담기
			moveList[l].offer(playerB);
			moveList[l + 1].offer(playerA);

		}

		// 큐에 담겨있는 선수들을 해당 리그에 추가해주기
		for (int l = 0; l < L; l++) {
			while (!moveList[l].isEmpty()) {
				Player p = moveList[l].poll();
				insertSort(l, p);
			}

		}

////		 선수 출력
//		for (int l = 0; l < L; l++) {
//			System.out.println(Arrays.toString(teamList[l].toArray()));
//		}
//		System.out.println(total);

		return total;
	}

	int trade() {

		int total = 0;

		// 각 리그에 교환해야하는 선수들 담는 큐선언
		Queue<Player>[] moveList = new ArrayDeque[L];
		moveList[0] = new ArrayDeque<>();

		for (int l = 0; l < L - 1; l++) {
			moveList[l + 1] = new ArrayDeque<>();

			Player playerA = new Player();
			Player playerB = new Player();

			// 교환 해야하는 선수들 변수에 담기
			if (teamList[l].size() != N / L) {

				// 원래의 중간 값을 뽑아내기 위해
				teamList[l].add(0, playerA);
				playerA = teamList[l].get((N / L) / 2);
				// 교환할 선수 원래 리그에서 제거
				teamList[l].remove((N / L) / 2);
				// 다시 0인덱스에 추가한 값 제거
				teamList[l].remove(0);
			} else {
				playerA = teamList[l].get((N / L) / 2);
				// 교환할 선수 원래 리그에서 제거
				teamList[l].remove((N / L) / 2);
			}
			playerB = teamList[l + 1].get(0);

			// 교환할 선수 원래 리그에서 제거
			teamList[l + 1].remove(0);

			// 교환할 선수의 id합하기
			total += playerA.id;
			total += playerB.id;

			// 교환 될 리그에 담는 큐에 해당 선수 담기
			moveList[l].offer(playerB);
			moveList[l + 1].offer(playerA);

		}

		// 큐에 담겨있는 선수들을 해당 리그에 추가해주기
		for (int l = 0; l < L; l++) {
			while (!moveList[l].isEmpty()) {
				Player p = moveList[l].poll();
				insertSort(l, p);
			}

		}

		

////		 선수 출력
//		for (int l = 0; l < L; l++) {
//			System.out.println(Arrays.toString(teamList[l].toArray()));
//		}
//		System.out.println(total);

		return total;
	}

}
