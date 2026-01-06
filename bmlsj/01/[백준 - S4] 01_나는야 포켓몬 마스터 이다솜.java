
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        HashMap<Integer, String> map2 = new HashMap<Integer, String>();
        for (int t = 0; t < N; t++) {
            String input = br.readLine();
            map.put(input, t + 1);
            map2.put(t + 1, input);
        }

        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            if (Character.isDigit(query.charAt(0))) {
                int num = Integer.parseInt(query);
                System.out.println(map2.get(num));
            } else {
                System.out.println(map.get(query));
            }
        }

    }

}
