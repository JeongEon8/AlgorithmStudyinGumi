import java.io.*;
import java.util.HashMap;

public class BOJ_15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);
        
        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        HashMap<Integer, Integer> sushiCount = new HashMap<>();
        int max = 0;

        for (int i = 0; i < k; i++) {
            sushiCount.put(sushi[i], sushiCount.getOrDefault(sushi[i], 0) + 1);
        }

        max = sushiCount.size();
        if (!sushiCount.containsKey(c)) {
            max++;
        }

        for (int i = 1; i < n; i++) {
            int prev = sushi[(i - 1) % n];
            int newSushi = sushi[(i + k - 1) % n];

            // 이전 초밥 제거...
            sushiCount.put(prev, sushiCount.get(prev) - 1);
            if (sushiCount.get(prev) == 0) {
                sushiCount.remove(prev);
            }

            // 새 초밥 추가...
            sushiCount.put(newSushi, sushiCount.getOrDefault(newSushi, 0) + 1);

            // 현재 종류 계산
            int current = sushiCount.size();
            if (!sushiCount.containsKey(c)) {
                current++;
            }

            max = Math.max(max, current);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
