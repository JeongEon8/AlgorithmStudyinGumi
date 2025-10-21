import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			String line = br.readLine();
			if (line.equals("end"))
				break;

			char[] arr = new char[9];
			for (int i = 0; i < 9; i++) {
				arr[i] = line.charAt(i);
			}

			boolean ans = isValid(arr);
			System.out.println(ans ? "valid" : "invalid");
		}

	}

	static boolean isValid(char[] arr) {

		int xcnt = 0, ocnt = 0;
		for (char c : arr) {
			if (c == 'X')
				xcnt++;
			else if (c == 'O')
				ocnt++;
		}

		if (ocnt > xcnt || xcnt > ocnt + 1)
			return false;

		// 2차원 배열로 변환
		char[][] map = new char[3][3];
		for (int i = 0; i < 9; i++) {
			map[i / 3][i % 3] = arr[i];
		}

		boolean xWin = false, oWin = false;

		// 가로, 세로 체크
        for (int i = 0; i < 3; i++) {
            if (map[i][0]=='X' && map[i][1]=='X' && map[i][2]=='X') xWin=true;
            if (map[0][i]=='X' && map[1][i]=='X' && map[2][i]=='X') xWin=true;
            if (map[i][0]=='O' && map[i][1]=='O' && map[i][2]=='O') oWin=true;
            if (map[0][i]=='O' && map[1][i]=='O' && map[2][i]=='O') oWin=true;
        }

        // 대각선 체크
        if (map[0][0]=='X' && map[1][1]=='X' && map[2][2]=='X') xWin=true;
        if (map[0][2]=='X' && map[1][1]=='X' && map[2][0]=='X') xWin=true;
        if (map[0][0]=='O' && map[1][1]=='O' && map[2][2]=='O') oWin=true;
        if (map[0][2]=='O' && map[1][1]=='O' && map[2][0]=='O') oWin=true;
        
        // X와 O가 동시에 승리하면 invalid
        if (xWin && oWin) return false;

        // 승리자와 개수 체크
        if (xWin && xcnt != ocnt + 1) return false;
        if (oWin && xcnt != ocnt) return false;

        // 승리자가 없으면 마지막까지 채워졌는지 확인
        if (!xWin && !oWin && xcnt + ocnt != 9) return false;
        
		return true;
	}

}
