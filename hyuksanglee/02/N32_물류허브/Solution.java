package N32_물류허브;

import java.util.Scanner;

class Solution {
	private final static int MAX_N = 1400;
	private final static int CMD_INIT = 1;
	private final static int CMD_ADD = 2;
	private final static int CMD_COST = 3;

	private final static UserSolution usersolution = new UserSolution();

	private static boolean run(Scanner sc) {
		int q = sc.nextInt();

		int n;
		int[] sCityArr = new int[MAX_N];
		int[] eCityArr = new int[MAX_N];
		int[] mCostArr = new int[MAX_N];
		int sCity, eCity, mCost, mHub;
		int cmd, ans, ret = 0;
		boolean okay = false;

		for (int i = 0; i < q; ++i) {
			cmd = sc.nextInt();
			switch (cmd) {
				case CMD_INIT:
					okay = true;
					n = sc.nextInt();
					for (int j = 0; j < n; ++j) {
						sCityArr[j] = sc.nextInt();
						eCityArr[j] = sc.nextInt();
						mCostArr[j] = sc.nextInt();
					}
					ans = sc.nextInt();
					ret = usersolution.init(n, sCityArr, eCityArr, mCostArr);
					if (ret != ans)
						okay = false;
					break;
				case CMD_ADD:
					sCity = sc.nextInt();
					eCity = sc.nextInt();
					mCost = sc.nextInt();
					usersolution.add(sCity, eCity, mCost);
					break;
				case CMD_COST:
					mHub = sc.nextInt();
					ans = sc.nextInt();
					ret = usersolution.cost(mHub);
					if (ret != ans)
						okay = false;
					break;
				default:
					okay = false;
					break;
			}
		}
		return okay;
	}

	public static void main(String[] args) throws Exception {
		int TC, MARK;

		//System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

		Scanner sc = new Scanner(System.in);

		TC = sc.nextInt();
		MARK = sc.nextInt();

		for (int testcase = 1; testcase <= TC; ++testcase) {
			int score = run(sc) ? MARK : 0;
			System.out.println("#" + testcase + " " + score);
		}

		sc.close();
	}
}
