import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();

        // 의상 종류별 개수 세기
        for (String[] c : clothes) {
            String type = c[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        int answer = 1;
        // 각 종류별 (개수 + 1) 곱하기
        for (int count : map.values()) {
            answer *= (count + 1);
        }

        // 아무것도 안 입는 경우 제외
        return answer - 1;
    }
}
