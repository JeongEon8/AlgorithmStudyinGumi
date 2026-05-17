class Solution {
    public int solution(String word) {
        int answer = 0;
        String vowel = "AEIOU";
        int total = 781;
        for(int i = 0; i<word.length();i++){
            int vowelToNum = vowel.indexOf(word.charAt(i));
            answer+= vowelToNum*total+1;
            total--;
            total/=5;
        }
        return answer;
    }
}