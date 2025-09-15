import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        int count = 0;
        HashSet<String> list = new HashSet<>();
        boolean fail = false;
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            count++;

            // 첫 단어는 그냥 넣기
            if (i == 0) {
                list.add(word);
                continue;
            }

            // 중보고 단어이거나, 앞단어의 마지막 글자로 시작하지 않으면 끝
            String prev = words[i - 1];
            if (list.contains(word) || prev.charAt(prev.length() - 1) != word.charAt(0)) {
                fail = true;
                break;
            }

            list.add(word);
        }

        int[] answer = new int[2];
        if (fail) { // 중간에 끊겼다면
            answer[1] = count / n + (count % n == 0 ? 0 : 1);
            answer[0] = count % n == 0 ? n : count % n;
        }

        return answer;
    }
}
