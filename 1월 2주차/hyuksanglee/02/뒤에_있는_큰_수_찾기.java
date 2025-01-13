package programmers;

import java.util.Stack;

class Solution1 {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < numbers.length; i++) {
            // 스택의 최상단 값과 비교하여 조건을 만족하면 결과 저장
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int index = stack.pop();
                answer[index] = numbers[i];
            }
            // 현재 인덱스를 스택에 추가
            stack.push(i);
        }

        // 스택에 남아 있는 인덱스는 오른쪽에 큰 값이 없음
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}
