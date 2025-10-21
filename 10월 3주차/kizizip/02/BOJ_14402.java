import java.util.*;

public class BOJ_14402 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < q; i++) {
            String name = sc.next();
            String action = sc.next();

            if (action.equals("+")) {
                map.put(name, map.getOrDefault(name, 0) + 1);
            } else { // "-"
                if (!map.containsKey(name) || map.get(name) == 0) {
                    count++; // 출근 기록 없이 퇴근
                } else {
                    map.put(name, map.get(name) - 1);
                }
            }
        }

        // 퇴근하지 않은 사람 수만큼 야근 추가
        for (int i : map.values()) {
            count += i;
        }

        System.out.println(count);
    }
}
