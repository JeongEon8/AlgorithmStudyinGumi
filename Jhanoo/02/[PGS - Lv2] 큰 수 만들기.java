import java.util.*;

class Solution {
    public String solution(String number, int k) {
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);

            while (k > 0 && stack.length() > 0) {
                if (stack.charAt(stack.length() - 1) >= current)
                    break;
                
                stack.deleteCharAt(stack.length() - 1);
                k--;
            }

            stack.append(current);
        }

        if (k > 0) {
            stack.setLength(stack.length() - k);
        }

        return stack.toString();
    }
}
