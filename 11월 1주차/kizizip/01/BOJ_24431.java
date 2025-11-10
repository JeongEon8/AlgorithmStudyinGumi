import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st1.nextToken());
            int l = Integer.parseInt(st1.nextToken()); 
            int f = Integer.parseInt(st1.nextToken()); 

            String[] words = new String[n];
            Set<String> set = new HashSet<>();
            int count = 0;

            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                words[j] = st2.nextToken();
            }

            for (int j = 0; j < n; j++) {
                String suffix = words[j].substring(l - f, l); // 마지막 f글자 추출

                if (!set.contains(suffix)) {
                    set.add(suffix);
                } else {
                    count++;
                    set.remove(suffix); // 중복 사용 방지
                }
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}
