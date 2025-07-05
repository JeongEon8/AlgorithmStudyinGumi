import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int M;
    static List<int[]> chicken;
    static List<int[]> houses;
    static boolean[] isSelected;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        M = Integer.parseInt(split[1]);

        int[][] map = new int[N][N];
        chicken = new ArrayList<>();
        houses = new ArrayList<>();

        // 치킨 집이랑 집 위치 저장
        for (int i = 0; i < N; i++) {
            split = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(split[j]);
                if (map[i][j] == 2) {
                    chicken.add(new int[]{i, j});
                } else if (map[i][j] == 1) {
                    houses.add(new int[]{i, j});
                }
            }
        }

        int result = Integer.MAX_VALUE;

        // M개의 치킨집을 구하는 조합 만들기
        isSelected = new boolean[chicken.size()];
        
        result = selectChicken(0, 0, result);

        System.out.println(result);
    }

    public static int selectChicken(int start, int count, int minDistance) {
        if (count == M) {
            int distance = calculateDistance();
            return Math.min(minDistance, distance);
        }

        for (int i = start; i < chicken.size(); i++) {
            isSelected[i] = true;
            minDistance = selectChicken(i + 1, count + 1, minDistance);
            isSelected[i] = false;
        }

        return minDistance;
    }

    public static int calculateDistance() {
        int totalDistance = 0;

        for (int[] house : houses) {
            int houseDistance = Integer.MAX_VALUE;
            for (int i = 0; i < chicken.size(); i++) {
                if (isSelected[i]) {
                    int[] c = chicken.get(i);
                    int distance = Math.abs(house[0] - c[0]) + Math.abs(house[1] - c[1]);
                    houseDistance = Math.min(houseDistance, distance);
                }
            }
            totalDistance += houseDistance;
        }

        return totalDistance;
    }
}