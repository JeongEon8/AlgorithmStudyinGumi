class Solution {
    public String solution(String s) {
        char[] line = s.toCharArray();
        if (Character.isLowerCase(line[0])) {
            line[0] = Character.toUpperCase(line[0]);
        }

        for (int i = 1; i < line.length; i++) {
            if (line[i-1] == ' ' && Character.isLowerCase(line[i])) {
                line[i] = Character.toUpperCase(line[i]);
            } else if (line[i-1] != ' ' && Character.isUpperCase(line[i])) {
                line[i] = Character.toLowerCase(line[i]);
            }
        }

        String answer = new String(line);
        
        return answer;
    }
}
