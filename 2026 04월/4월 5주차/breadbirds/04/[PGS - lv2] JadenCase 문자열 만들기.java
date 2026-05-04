import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        // " " 기준으로 문자열 잘라서 배열에 넣음
        String[] arr = s.split(" ");
        // 잘린 문자열을 순서대로 처리
        for(int i=0; i<arr.length; i++) {
            String now = arr[i];

            // 문자열의 길이가 0이라면(공백 이라면)
            // answer에 " "만 추가
            if(arr[i].length() == 0) {
                answer += " ";
            }
            // 문자가 있다면
            else {
                // 0번째 문자는 대문자로
                answer += now.substring(0, 1).toUpperCase();
                // 1번째 문자부터 마지막까지는 소문자로
                answer += now.substring(1, now.length()).toLowerCase();
                // 마지막에 " " 추가
                answer += " ";
            }

        }

        // 입력 받은 문자열의 맨 마지막이 " " 라면 바로 answer 반환
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            return answer;
        }

        // 맨 마지막 " " 제거하고 answer 반환
        return answer.substring(0, answer.length()-1);
    }

}