class Solution {
    public int solution(String name) {
        int answer = 0;
        // 총 26개
        char[] charList = name.toCharArray();
        for(char ch: charList) {
            if (ch - 'A' < Math.abs(ch - 'Z')) {
                answer += ch - 'A';
            } else {
                answer += Math.abs(ch - 'Z') + 1;
            }
        }
        int length = name.length();
        int move = length - 1; // 기본: 오른쪽으로 쭉 이동
        for (int i = 0; i < length; i++) {
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') next++;
            // 오른쪽으로 i만큼 갔다가, 뒤에서 돌아오는 경우
            move = Math.min(move, i + length - next + Math.min(i, length - next));
        }
        
        return answer + move;
    }
}