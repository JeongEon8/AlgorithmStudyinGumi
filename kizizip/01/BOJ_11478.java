import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ_11478 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String msg = br.readLine();
        HashSet<String> parts = new HashSet<>();

        // 부분 문자열 길이: 1 ~ msg.length()
        for (int len = 1; len <= msg.length(); len++) {
            for (int start = 0; start + len <= msg.length(); start++) {
                parts.add(msg.substring(start, start + len));
            }
        }

        System.out.println(parts.size());
    }
}
