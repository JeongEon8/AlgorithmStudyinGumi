import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_29812 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String S = br.readLine();
		sb.append(S);
		String[] strArr = br.readLine().split(" ");
		int D = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		int energy = 0;
		int countHYU = Integer.MAX_VALUE;
		HashMap<Character, Integer> counts = new HashMap<>();
		counts.put('H', 0);
		counts.put('Y', 0);
		counts.put('U', 0);

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'H' || S.charAt(i) == 'Y' || S.charAt(i) == 'U') {
				counts.put(S.charAt(i), counts.get(S.charAt(i)) + 1);
				continue;
			} else {
				int index = 1;
				while (i + index < S.length()) {
					if (S.charAt(i + index) == 'H' || S.charAt(i + index) == 'Y' || S.charAt(i + index) == 'U') {
						break;
					}
					index++;
				}

				sb.delete(i, i + index);
				S = sb.toString();
				if (index > 1) {
					if(D + M > D * index) {
						energy += D * index;
					}else {
						energy += D + M;
					}
				} else {
					energy += D;
				}
				i--;
			}
		}

		for (int count : counts.values()) {
			if (countHYU > count) {
				countHYU = count;
			}
		}
		
		sb.setLength(0);
		if (energy == 0) {
			sb.append("Nalmeok\n");
		} else {
			sb.append(energy + "\n");
		}
		if (countHYU == 0) {
			sb.append("I love HanYang University");
		} else {
			sb.append(countHYU);
		}

		System.out.print(sb.toString());
	}

}