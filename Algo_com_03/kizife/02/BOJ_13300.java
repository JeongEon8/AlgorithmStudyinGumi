import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); //학생 수
        int K = sc.nextInt(); //한 방 최대 인원 수

        int[][] arr = new int[2][7];
        int count = 0;
        
        for (int i = 0; i < N; i++) {
            int gender = sc.nextInt();
            int grade = sc.nextInt();
            
            arr[gender][grade]++; //각 배열값의 빈도수(해당 학년/성별의 학생 수)
        }
        
        for(int i=0; i<2; i++) {
            for (int j = 1; j <= 6; j++) {
                count += arr[i][j] / K;
                
                if (arr[i][j]%K != 0) {
                    count++;
                }
            }
        }
        
        System.out.println(count);
        
    }
}
