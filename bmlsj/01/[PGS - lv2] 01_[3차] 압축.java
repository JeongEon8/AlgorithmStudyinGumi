import java.util.*;
class Solution {
    static int[] solution(String msg) {

		List<Integer> result = new ArrayList<>();

		HashMap<String, Integer> dict = new HashMap();
		for (char c = 'A'; c <= 'Z'; c++) {
			dict.put(c + "", c - 'A' + 1);
		}

		int start = 0;
		int idx = 27;
        while (start < msg.length()) {

            StringBuilder sb = new StringBuilder();
            String find = "";
            int len = 0;

            for (int i = start; i < msg.length(); i++) {
                // 글자 추가
                sb.append(msg.charAt(i));
                String curr = sb.toString();

                // 사전에 있으면
                if (dict.containsKey(curr)) {
                    find = curr;
                    len++;
                    continue;
                } else {
                    dict.put(sb.toString(), idx++);
                    break;
                }
            }

            result.add(dict.get(find));
            start += len;
        }
        
		int[] answer = new int[result.size()];
		for (int i = 0; i < result.size(); i++) {
			answer[i] = result.get(i);
		}
		return answer;
	}
}