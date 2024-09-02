import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //전체 날짜 수
        int K = sc.nextInt(); //연속해서 더할 날짜 수

        int[] arr = new int[N];
        
        for (int i = 0; i < N; i++) { //배열에 온도 저장
            arr[i] = sc.nextInt();
        }

        int maxSum = Integer.MIN_VALUE; //최댓값 초기화
       
        for (int i = 0; i < N - K + 1; i++) { //조합의 수
            int result = 0;
            for (int j = 0; j < K; j++) { //한 조합의 합을 구하기
                result += arr[i + j];
            }
            if (result > maxSum) { //각 조합의 합들 중 최댓값 저장
                maxSum = result;
            }
            
        }
        System.out.println(maxSum); //최댓값 출력

    }

}
