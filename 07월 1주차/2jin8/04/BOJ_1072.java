import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1072 {

    static int X, Y, Z;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = (int) (((long) Y * 100 / X));

        // X번 다 이겼는데도 변경되지 않으면 안 바뀌는 것
        binarySearch(1, X);
    }

    public static void binarySearch(int left, int right) {
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2; // 추가로 하는 게임의 횟수
            int newX = X + mid;
            int newY = Y + mid;
            int newZ = (int) (((long) newY * 100) / newX);

            // Z가 바뀌는 경우, 추가 게임 횟수 줄이기
            if (Z != newZ) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
    }
}
