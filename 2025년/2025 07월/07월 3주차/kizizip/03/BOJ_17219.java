import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int m = Integer.parseInt(firstLine[1]);

        Map<String, String> passwords = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] entry = br.readLine().split(" ");
            passwords.put(entry[0], entry[1]);
        }

        for (int i = 0; i < m; i++) {
            String site = br.readLine();
            String password = passwords.get(site);
            System.out.println(password);
        }
    }
}
