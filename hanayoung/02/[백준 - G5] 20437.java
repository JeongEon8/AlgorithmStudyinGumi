import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(bf.readLine());
            String str = st.nextToken();
            st = new StringTokenizer(bf.readLine());
            int K = Integer.parseInt(st.nextToken());
            int[] answer = new int[2];
            answer[0] = Integer.MAX_VALUE;

            ArrayList<Integer>[] pos = new ArrayList[26];
            for(int i = 0; i < 26; i++) {
                pos[i] = new ArrayList<>();
            }

            for(int i = 0; i < str.length(); i++) {
                pos[str.charAt(i) - 'a'].add(i);
            }

            for (ArrayList<Integer> po : pos) {
                if (po.size() < K) {
                    continue;
                }
                for (int j = 0; j <= po.size() - K; j++) {
                    int len = po.get(j+K-1) - po.get(j) + 1;
                    answer[0] = Math.min(answer[0], len);
                    answer[1] = Math.max(answer[1], len);
                }
            }

            if(answer[0] == Integer.MAX_VALUE || answer[1] == 0) sb.append(-1);
            else sb.append(answer[0]).append(" ").append(answer[1]);

            sb.append("\n");

        }
        System.out.println(sb);
    }
}
