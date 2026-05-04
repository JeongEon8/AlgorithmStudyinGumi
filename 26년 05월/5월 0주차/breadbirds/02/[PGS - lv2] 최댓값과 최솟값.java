class Solution {
    public String solution(String s) {
        // 공백으로 구분된 문자열을 숫자 배열로 변환
        String[] arr = s.split(" ");

        // 첫 번째 숫자를 기준으로 최소값과 최대값 초기화
        int min = Integer.parseInt(arr[0]);
        int max = Integer.parseInt(arr[0]);

        // 배열의 나머지 숫자를 순회하며 최소값과 최대값 찾기
        for (String numStr : arr) {
            int num = Integer.parseInt(numStr);
            if (num > max) max = num;
            if (num < min) min = num;
        }

        // 최소값과 최대값을 반환
        return min + " " + max;
    }
}