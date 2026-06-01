class Solution {
    boolean solution(String s) {
        int pCount = 0;
        int yCount = 0;

        s = s.toLowerCase();

        for (char c : s.toCharArray()) {

            if (c == 'p') {
                pCount++;
            } else if (c == 'y') {
                yCount++;
            }
        }

        return pCount == yCount;
    }
}
