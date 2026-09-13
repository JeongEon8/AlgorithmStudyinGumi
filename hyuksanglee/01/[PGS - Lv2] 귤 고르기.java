import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : tangerine) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(map.values());

        list.sort(Comparator.reverseOrder());

        int total = 0;

        for (int n : list) {
            total += n;
            answer++;

            if (total >= k) {
                break;
            }
        }

        return answer;
    }
}
