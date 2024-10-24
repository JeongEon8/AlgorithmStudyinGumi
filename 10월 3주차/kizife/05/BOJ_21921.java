import java.util.Scanner;

public class BOJ_21921 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] arr = new int[n];
		
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int result = 0;
		int count = 1;
		
		for (int i = 0; i < x; i++) {
			result += arr[i];
		}
		
		int start = result;
		
		for (int i = 1; i <= n-x; i++) {
			start = start-arr[i-1] + arr[i+x-1];
			
			if(start>result) {
				result = start;
				count = 1;
			} else if (start == result ) {
				count++;
			}
		}
		
		if (result == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(result);
			System.out.println(count);
		}
		
	}

}
