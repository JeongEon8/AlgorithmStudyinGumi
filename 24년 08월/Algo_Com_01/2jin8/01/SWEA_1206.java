import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1206 {
    /**
     * 테스트 개수는 총 10개
     * n: 건물의 개수
     * heights: 건물의 높이
     * total: 조망권이 확보된 세대의 수
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            // 건물의 개수, 건물의 높이 저장하기
            int n = Integer.parseInt(br.readLine());
            int[] heights = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            // 조망권이 확보된 세대의 수 찾기
            int total = 0;
            // 맨 왼쪽 두 칸과 오른쪽 두 칸에는 건물이 지어지지 않으므로 2 ~ (n - 3)까지 반복하기
            for (int i = 2; i < n - 2; i++) {
                int height = heights[i];
                // 양 옆 건물의 최대 높이 구하기
                int max = Math.max(Math.max(heights[i - 2], heights[i - 1]), Math.max(heights[i + 1], heights[i + 2]));
                if (height > max) { // 양 옆 건물의 최대 높이보다 현재 건물의 높이가 크다면
                    total += height - max; // 조망권이 확보됨
                }
            }
            sb.append("#").append(t).append(" ").append(total).append("\n");
        }
        System.out.println(sb);
    }
}