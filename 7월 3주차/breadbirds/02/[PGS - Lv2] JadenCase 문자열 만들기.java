class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();

        boolean isFirst = true;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ' ') {
                answer.append(ch);
                isFirst = true;
            } else {
                if (isFirst) {
                    answer.append(Character.toUpperCase(ch));
                    isFirst = false;
                } else {
                    answer.append(Character.toLowerCase(ch));
                }
            }
        }

        return answer.toString();
    }
}
