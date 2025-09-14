import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_22941 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		long playerHp = Integer.parseInt(strArr[0]);
		int playerAtk = Integer.parseInt(strArr[1]);
		long demonHp = Integer.parseInt(strArr[2]);
		int demonAtk = Integer.parseInt(strArr[3]);
		strArr = br.readLine().split(" ");
		int P = Integer.parseInt(strArr[0]);
		int S = Integer.parseInt(strArr[1]);

		long playerDethCount = playerHp % demonAtk == 0 ? playerHp / demonAtk : playerHp / demonAtk + 1;
		long demonDethCount = (demonHp - P) % playerAtk == 0 ? (demonHp - P) / playerAtk
				: (demonHp - P) / playerAtk + 1;

		demonHp -= (demonDethCount) * playerAtk;
		demonHp = demonHp <= 0 ? 0 : demonHp + S;
		demonDethCount += demonHp % playerAtk == 0 ? demonHp / playerAtk : demonHp / playerAtk + 1;

		if (playerDethCount >= demonDethCount) {
			System.out.println("Victory!");
		} else {
			System.out.println("gg");
		}
	}
}