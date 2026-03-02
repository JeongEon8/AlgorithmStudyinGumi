import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static char[][] cookie;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		cookie = new char[N][N];
		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				cookie[i][j] = split[j].charAt(0);
			}
		}

		int heart_x = 0, heart_y = 0;
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				if (cookie[i][j] == '*') {
					// 상하좌우가 모두 * 면, 심장
					if (cookie[i - 1][j] == '*' && cookie[i + 1][j] == '*' && cookie[i][j - 1] == '*'
							&& cookie[i][j + 1] == '*') {
						heart_x = i;
						heart_y = j;
						break;
					}
				}
			}
			if (heart_x != 0)
				break;
		}

		int leftArm = 0;
		int y = heart_y - 1;
		while (y >= 0 && cookie[heart_x][y] == '*') {
			leftArm++;
			y--;
		}

		int rightArm = 0;
		y = heart_y + 1;
		while (y < N && cookie[heart_x][y] == '*') {
			rightArm++;
			y++;
		}

		int waist = 0;
		int x = heart_x + 1;
		while (x < N && cookie[x][heart_y] == '*') {
			waist++;
			x++;
		}

		int waistEnd = waist + heart_x;
		int leftLeg = 0;
		x = waistEnd + 1;
		y = heart_y - 1;

		while (x < N && cookie[x][y] == '*') {
			x++;
			leftLeg++;
		}

		int rightLeg = 0;
		x = waistEnd + 1;
		y = heart_y + 1;
		while (x < N && cookie[x][y] == '*') {
			x++;
			rightLeg++;
		}

		System.out.println((heart_x + 1) + " " + (heart_y + 1));
		System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);

	}

}