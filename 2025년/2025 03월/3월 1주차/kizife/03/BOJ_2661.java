import java.util.*;

public class Main {

    static int n ;
    static int[] arr;
    static boolean end = false; // 좋은 수열 찾으면 끝내기 위한 분기점 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];

        dfs(0);
    }

    public static void dfs(int depth) {
        if (end) return; //좋은 수열 찾은 상태면 종료
        if (depth == n) { //길이가 n인 좋은 수열 찾으면 출력하고 분기점=true
            for (int num : arr) System.out.print(num);
            end = true;
            return;
        }

        for (int i = 1; i <= 3; i++) {
            arr[depth] = i; //현재 자리에 숫자 배정

            if (checkArr(depth+1)) { //좋은 수열이면, 탐색 계속
                dfs(depth+1);
            }
        }
    }

    public static boolean checkArr(int length) {
        for (int i = 1; i <= length/2 ; i++) { //전체길이 반까지, 부분적으로 검토함 
            boolean same = true;
            for (int j = 0; j < i; j++) {
                if (arr[length-2*i+j] != arr[length-i+j]) { // 인덱스 i지점의 앞뒤를 비교함. 
                  // 같지 않다면 same=false임 
                    same = false;
                    break;
                }

            }
            if (same ) return false; //나쁜 수열이면 false
        }
        return true; //좋은 수열이면 true 반환 
    }
}
