
import java.util.*;

class Solution {

    public String[] solution(String[] orders, int[] course) {

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int c : course) {

            map.clear();
            for (String order : orders) {
                char[] arr = order.toCharArray();
                Arrays.sort(arr);

                comb(arr, "", 0, c, map);
            }

            int max = 0;
            for (String key : map.keySet()) {
                if (map.get(key) >= 2) {
                    max = Math.max(max, map.get(key));
                }
            }

            for (String key : map.keySet()) {
                if (map.get(key) == max && max >= 2) {
                    list.add(key);
                }
            }
        }

        Collections.sort(list);

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public void comb(char[] arr, String str, int idx, int len, Map<String, Integer> map) {

        if (str.length() == len) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            comb(arr, str + arr[i], i + 1, len, map);
        }
    }

    public boolean containsMenu(String order, String menu) {
        for (char c : menu.toCharArray()) {
            if (order.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }
}
