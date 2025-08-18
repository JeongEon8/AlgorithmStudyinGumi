import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1027 {

    static int N;
    static int[] heights;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        heights = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int x1 = i, y1 = heights[i];
            int count = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;

                boolean isWatch = true;
                int x2 = j, y2 = heights[j];

                // 직선 식 구하기
                double a = ((double) (y2 - y1)) / ((double) (x2 - x1));
                double b = ((y1 + y2) - a * (x1 + x2)) / 2;

                // x = k일 때 y값이 직선보다 위에 있다면 해당 건물을 볼 수 없음
                int start = Math.min(x1, x2), end = Math.max(x1, x2);
                for (int k = start + 1; k < end; k++) {
                    int x3 = k, y3 = heights[k];
                    if (a * x3 + b <= y3) {
                        isWatch = false;
                        break;
                    }
                }
                if (isWatch) count++;
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }
}
