import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		String[] kings = split[0].split("");
		String[] stones = split[1].split("");
		int N = Integer.parseInt(split[2]);

		for (int i = 0; i < N; i++) {
			String move = br.readLine();
			int dx = 0;
			int dy = 0;

			switch (move) {
			case "R":
				dx = 1;
				dy = 0;
				break;
			case "L":
				dx = -1;
				dy = 0;
				break;
			case "B":
				dx = 0;
				dy = -1;
				break;
			case "T":
				dx = 0;
				dy = 1;
				break;
			case "RT":
				dx = 1;
				dy = 1;
				break;
			case "LT":
				dx = -1;
				dy = 1;
				break;
			case "RB":
				dx = 1;
				dy = -1;
				break;
			case "LB":
				dx = -1;
				dy = -1;
				break;
			}

			int kingX = kings[0].charAt(0) - 'A';
			int kingY = Integer.parseInt(kings[1]) - 1;

			int stoneX = stones[0].charAt(0) - 'A';
			int stoneY = Integer.parseInt(stones[1]) - 1;

			int nextKingX = kingX + dx;
			int nextKingY = kingY + dy;

			if (nextKingX < 0 || nextKingX >= 8 || nextKingY < 0 || nextKingY >= 8)
				continue;

			if (nextKingX == stoneX && nextKingY == stoneY) {
				int nextStoneX = stoneX + dx;
				int nextStoneY = stoneY + dy;
				if (nextStoneX < 0 || nextStoneX >= 8 || nextStoneY < 0 || nextStoneY >= 8)
					continue;

				stoneX = nextStoneX;
				stoneY = nextStoneY;

			}

			kingX = nextKingX;
			kingY = nextKingY;

			kings[0] = String.valueOf((char) (kingX + 'A'));
			kings[1] = String.valueOf(kingY + 1);

			stones[0] = String.valueOf((char) (stoneX + 'A'));
			stones[1] = String.valueOf(stoneY + 1);

		}

		System.out.println(kings[0] + kings[1]);
		System.out.println(stones[0] + stones[1]);

	}

}