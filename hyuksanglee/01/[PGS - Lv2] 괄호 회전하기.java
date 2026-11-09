import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Queue<Character> que = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            que.add(s.charAt(i));
        }

        int n = que.size();
        for (int i = 0; i < n; i++) {
            que.add(que.poll());
            if (check(que)) {
                answer++;
            }
        }
        return answer;
    }

    static boolean check(Queue<Character> que) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : que) {           
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if (c == ')' && open != '(') return false;
                if (c == '}' && open != '{') return false;
                if (c == ']' && open != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
