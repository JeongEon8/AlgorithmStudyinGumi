import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        // 각 크기별로 개수 세기
        for (int size : tangerine) {
            map.put(size, map.getOrDefault(size, 0) + 1);
        }

        // 크기별 개수를 내림차순 정렬
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());

        // 많이 있는 크기부터 선택
        int sum = 0;
        int kind = 0;
        for (int c : counts) {
            sum += c;
            kind++;
            if (sum >= k) break;
        }

        return kind;
    }
}
