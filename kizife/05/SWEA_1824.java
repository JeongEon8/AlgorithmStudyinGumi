//미완성입니다......

import java.util.Scanner;

public class Solution {

	static char[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			sc.nextLine();
			
			arr = new char[r][c];
			for (int j = 0; j < r; j++) {
				String line = sc.nextLine();
				for (int j2 = 0; j2 < c; j2++) {
					arr[j][j2] = line.charAt(j);
					
//					System.out.println(arr[j][j2]);
				}
			}
		}
	}
}
