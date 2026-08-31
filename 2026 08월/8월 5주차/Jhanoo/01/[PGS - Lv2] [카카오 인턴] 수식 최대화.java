import java.util.*;

class Solution {
    public long solution(String expression) {
        List<Character> ops = new ArrayList<>();
        List<Long> numbers = new ArrayList<>();
        
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                ops.add(c);
            }
        }

        String[] nums = expression.split("[+\\-*]");
        
        for (String num : nums) {
            numbers.add(Long.parseLong(num));
        }
        
        char[][] priorities = {
            {'+', '-', '*'},
            {'+', '*', '-'},
            {'-', '+', '*'},
            {'-', '*', '+'},
            {'*', '+', '-'},
            {'*', '-', '+'}
        };
        
        long answer = 0;
        for (char[] priority : priorities) {
            long cur = getAbs(numbers, ops, priority);
            answer = Math.max(answer, cur);
        }
        
        return answer;
    }
    
    public static long getAbs(List<Long> numbers, List<Character> ops, char[] priority) {
        List<Long> numList = new ArrayList<>(numbers);
        List<Character> opList = new ArrayList<>(ops);
        
        for (char op : priority) {
            for (int i = 0; i < opList.size(); i++) {
                if (opList.get(i) == op) {
                    long result = calc(numList.get(i), numList.get(i + 1), op);
                    
                    numList.set(i, result);
                    numList.remove(i + 1);
                    opList.remove(i--);
                }
            }
        }
        
        return Math.abs(numList.get(0));
    }
    
    public static long calc(long a, long b, char op) {
        if (op == '+') return a + b;
        if (op == '-') return a - b;
        if (op == '*') return a * b;
        
        return 0;
    }
}
