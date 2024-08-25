import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] split = in.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int S = Integer.parseInt(split[1]);
        int R = Integer.parseInt(split[2]);
        int[] kStates = new int[N + 1];
        split = in.readLine().split(" ");
        for (int i = 0; i < S; i++) {
            kStates[Integer.parseInt(split[i])]--;
        }
        split = in.readLine().split(" ");
        for (int i = 0; i < R; i++) {
            kStates[Integer.parseInt(split[i])]++;
        }
        for (int i = 1; i <= N; i++) {
            if (i - 1 > 0 && kStates[i - 1] == -1 && kStates[i] == 1) {
                kStates[i - 1]++;
                kStates[i]--;
            }
            if (i + 1 <= N && kStates[i + 1] == -1 && kStates[i] == 1) {
                kStates[i + 1]++;
                kStates[i]--;
            }
        }
        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (kStates[i] == -1) {
                ans++;
            }
        }
        System.out.println(ans);
    }

}