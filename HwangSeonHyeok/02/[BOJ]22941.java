import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static long heroHP, heroATK, monsterHP, monsterATK, p, s;

	static boolean Play() {
		long turn = heroHP / monsterATK;
		if (heroHP % monsterATK != 0) {
			turn++;
		}
		long ddalP = monsterHP % heroATK;
		if (ddalP == 0)
			ddalP += heroATK;
		if (ddalP >= 1 && ddalP <= p) {
			monsterHP += s;
		}
		long requireTurn = monsterHP / heroATK;
		if (monsterHP % heroATK != 0) {
			requireTurn++;
		}
		if (requireTurn <= turn) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		heroHP = Long.parseLong(st.nextToken());
		heroATK = Long.parseLong(st.nextToken());
		monsterHP = Long.parseLong(st.nextToken());
		monsterATK = Long.parseLong(st.nextToken());
		st = new StringTokenizer(in.readLine());
		p = Long.parseLong(st.nextToken());
		s = Long.parseLong(st.nextToken());

		if (Play()) {
			System.out.println("Victory!");
		} else {
			System.out.println("gg");
		}

	}

}