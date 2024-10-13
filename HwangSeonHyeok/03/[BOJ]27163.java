import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static class Aura {
		int value, parent;
		boolean isAuraD;

		public Aura(int aura, int parent, boolean isAuraD) {
			this.value = aura;
			this.parent = parent;
			this.isAuraD = isAuraD;
		}

	}

	static Aura[][] dp;

	static String makeAns(int n, Aura a) {
		String ans = a.isAuraD ? "A" : "L";
		if (a.parent == -1) {
			return ans;
		}
		return makeAns(n - 1, dp[n - 1][a.parent]) + ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String[] split = in.readLine().split(" ");
		int n = Integer.parseInt(split[0]);
		int a = Integer.parseInt(split[1]);
		int l = Integer.parseInt(split[2]);
		dp = new Aura[n][l];// n번째 l라이프 받은 데미지. 여기선 0이되면 안되니까 l+1이 아니라 l로 2는 마지막으로 받은게 오라인지 라이프인지.
		split = in.readLine().split(" ");
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);
		if (x != -1) {
			if (y == -1) {
				dp[0][0] = new Aura(Math.min(x, a), -1, true);
			} else if (x <= a) {
				dp[0][0] = new Aura(x, -1, true);
			}
		}
		if (y != -1 && y < l) {
			dp[0][y] = new Aura(0, -1, false);
		}
		for (int i = 1; i < n; i++) {
			split = in.readLine().split(" ");
			x = Integer.parseInt(split[0]);
			y = Integer.parseInt(split[1]);
			for (int j = 0; j < l; j++) {
				// 라이프로 데미지 받는 경우
				if (y != -1 && j >= y && dp[i - 1][j - y] != null) {
					if (dp[i][j] == null) {
						dp[i][j] = new Aura(dp[i - 1][j - y].value, j - y, false);
					} else if (dp[i - 1][j - y].value < dp[i][j].value) {
						dp[i][j] = new Aura(dp[i - 1][j - y].value, j - y, false);
					}
				}
				// 오라로 받는 경우
				if (x != -1 && dp[i - 1][j] != null) {
					if (dp[i][j] == null) {
						if (y == -1) {
							dp[i][j] = new Aura(Math.min(dp[i - 1][j].value + x, a), j, true);
						} else if (dp[i - 1][j].value + x <= a) {
							dp[i][j] = new Aura(dp[i - 1][j].value + x, j, true);
						}
					} else if (dp[i - 1][j].value + x < dp[i][j].value) {
						dp[i][j] = new Aura(dp[i - 1][j].value + x, j, true);
					}
				}

			}
		}
		boolean yes = false;
		for (Aura result : dp[n - 1]) {
			if (result != null) {
				yes = true;
				System.out.println("YES");
				System.out.println(makeAns(n - 1, result));
				break;
			}
		}
		if (!yes) {
			System.out.println("NO");
		}
	}

}