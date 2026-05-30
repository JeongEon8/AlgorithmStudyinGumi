class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder gameSequence = new StringBuilder();
        
        int currentNumber = 0;
        int targetLength = t * m;
        while (gameSequence.length() < targetLength) {
            String converted = Integer.toString(currentNumber, n).toUpperCase();
            gameSequence.append(converted);
            currentNumber++;
        }
        
        for (int i = 0; i < t; i++) {
            int tubeIndex = (p - 1) + (i * m);
            answer.append(gameSequence.charAt(tubeIndex));
        }
        
        return answer.toString();
    }
}
