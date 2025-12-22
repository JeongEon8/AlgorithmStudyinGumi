import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][n];
        char[][] result = new char[n][n];

        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != '.') {
                    result[i][j] = '*'; // 지뢰 = *
                } else {
                    int sum = 0;
                    for (int d = 0; d < 8; d++) {
                        int x = i + dx[d];
                        int y = j + dy[d];

                        if (x >= 0 && x < n && y >= 0 && y < n) {
                            if (Character.isDigit(map[x][y])) { // 숫자라면..
                                sum += map[x][y] - '0';
                            }
                        }
                    }

                    if (sum >= 10) {
                        result[i][j] = 'M';
                    } else {
                        result[i][j] = (char)(sum + '0');
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(new String(result[i]));
        }
    }
}
