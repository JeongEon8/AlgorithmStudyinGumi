import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int switchNum = sc.nextInt(); // 스위치 개수 입력

        // 스위치 배열 만들기
        int[] arr = new int[switchNum];

        for (int i = 0; i < switchNum; i++) { // 스위치 온오프값 입력
            arr[i] = sc.nextInt();
        }

        int stuNum = sc.nextInt(); // 학생 수 입력

        for (int j = 0; j < stuNum; j++) { // 학생 수만큼 반복
            int gender = sc.nextInt();
            int gotNum = sc.nextInt() -1 ;

            if (gender == 1) { // 남학생이라면

                for (int k = 0; k < switchNum; k++) { // 스위치 순회
                    if ((k + 1) % (gotNum+1) == 0) { // 받은 숫자의 배수인 스위치라면
                        if (arr[k] == 0) { // 0인 스위치를 1로 바꾸고
                            arr[k] = 1;
                        } else { // 1인 스위치를 0으로 바꿈
                            arr[k] = 0;
                        }
                    }
                }
            }

            else if (gender == 2) { // 여학생이라면
                int left = gotNum - 1; // 왼쪽 인덱스
                int right = gotNum +1; // 오른쪽 인덱스

                if (arr[gotNum] == 0) {
                    arr[gotNum] = 1;
                } else {
                    arr[gotNum] = 0;
                }

                
                while (left >= 0 && right < switchNum) { // 대칭 이루는 스위치 페어까지
                    if( arr[left] != arr[right] ) break;
                    
                    if (arr[left] == 0) { // 페어의 값이 0이라면 1로 바꿈
                        arr[left] = 1;
                        arr[right] = 1;

                    } else { // 페어의 값이 1이라면 0으로 바꿈
                        arr[left] = 0;
                        arr[right] = 0;
                    }

                    left--;
                    right++;
                }

            }
        }

        for (int i = 0; i < switchNum; i++) {
            if(i%20 == 0 && i!=0) {
                System.out.println();
            }
            
            System.out.print(arr[i] + " ");
            
            
        }

        System.out.println();
    }

}
