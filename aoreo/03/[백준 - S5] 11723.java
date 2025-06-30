import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer, Boolean> trueMap = new HashMap<>();
        HashMap<Integer, Boolean> falseMap = new HashMap<>();
        for (int j = 1; j <= 20; j++) {
            trueMap.put(j, true);
            falseMap.put(j, false);
            hashMap.put(j, false);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            String command = st.nextToken();
            if (command.equals("add")) {
                hashMap.put(Integer.valueOf(st.nextToken()), true);
            } else if (command.equals("remove")) {
                hashMap.put(Integer.valueOf(st.nextToken()), false);
            } else if (command.equals("check")) {
                Integer value = Integer.valueOf(st.nextToken());
                if (hashMap.get(value) == true) {
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
            } else if (command.equals("toggle")) {
                Integer num = Integer.valueOf(st.nextToken());
                if (hashMap.get(num) == true) {
                    hashMap.put(num, false);
                } else {
                    hashMap.put(num, true);
                }
            } else if (command.equals("all")) {
                hashMap.putAll(trueMap);
            } else if (command.equals("empty")) {
                hashMap.putAll(falseMap);
            }
        }

        System.out.println(sb);
    }
}
