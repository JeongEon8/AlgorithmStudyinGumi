import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt();
      int X = sc.nextInt();

      int[] arr = new int[N]; //배열 선언

      for(int i=0; i<N; i++) { //배열 입력
        arr[i] = sc.nextInt();
      }
      
        for(int i=0; i<N; i++) {
          if(arr[i]<X) {
            System.out.print(arr[i] + " ");
          }
        }
      }
  }

