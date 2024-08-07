import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class SWEA_5658 {
        static int N, K;
        static HashSet<String> password = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            password.clear();

            String box = br.readLine();
            box += box;
            int repeat = N / 4;
            for (int i = 0; i < repeat; i++) {
                for (int j = 0; j < 4; j++) {
                    int start = i + repeat * j;
                    password.add(box.substring(start, start + repeat));
                }
            }
            List<String> pwList = password.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
            String pw = pwList.get(K - 1);
//            sb.append("#").append(t).append(" ").append(Integer.parseInt(pw, 16)).append("\n");
            sb.append("#").append(t).append(" ").append(getNum(pwList.get(K - 1))).append("\n");
        }
        System.out.println(sb);
    }

    static int getNum(String str) {
        int total = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int num = 0;
            if (c - 'A' < 0) {
                num = c - '0';
            } else {
                num = (c - 'A') + 10;
            }
            total += num * (int) Math.pow(16, str.length() - i - 1);
        }
        return total;
    }
}
