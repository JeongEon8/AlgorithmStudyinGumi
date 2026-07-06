import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        // 배열 B 는 내림차순 정렬하기
        for(int i = 0; i < B.length/2; i++){
            int temp = B[i];
            B[i] = B[B.length - i - 1];
            B[B.length-i-1] = temp;
            
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int i = 0; i < A.length;i++){
            answer += A[i]*B[i];
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        return answer;
    }
}
