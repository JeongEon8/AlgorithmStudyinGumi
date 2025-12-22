import java.util.Scanner;

public class BOJ_2195 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        String P = sc.next();

        int copyCount = 0; //복사 횟수
        int pIndex = 0; //P의 인덱스

        // P를 순회하며 S에서 복사 가능한 부분 문자열을 찾음
        while (pIndex < P.length()) {
            int maxLength = 0; // pIndex부터 복사 가능한 최대 길이

            // S에서 P[pIndex]와 일치하는 부분 탐색
            for (int start = 0; start < S.length(); start++) {
                int currentLength = 0;

                // 부분 문자열이 일치하는 최대 길이 계산
                while (start + currentLength < S.length() &&
                        pIndex + currentLength < P.length() &&
                        S.charAt(start + currentLength) == P.charAt(pIndex + currentLength)) {
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }

            // 복사가 가능한 경우, 해당 길이만큼 이동하고 복사 횟수++
            pIndex += maxLength;
            copyCount++;
        }

        System.out.println(copyCount);
    }
}
