import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BOJ_1026 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<Integer> listA = new ArrayList<>();
		ArrayList<Integer> listB = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			listA.add(sc.nextInt());
		}
		for (int i = 0; i < n; i++) {
			listB.add(sc.nextInt());
		}
		
		Collections.sort(listA);
		Collections.sort(listB);
		
		int[] arrA = new int[listA.size()];
		int size = 0;
		for(int temp:listA) {
			arrA[size++] = temp;
		}
		
		int[] arrB = new int[listB.size()];
		size = 0;
		for(int temp:listB) {
			arrB[size++] = temp;
		}
		
		int result = 0;
		for (int i = 0; i < n; i++) {
			int num = arrA[i] * arrB[n-1-i];
			
			result += num;
		}
		
		System.out.println(result);
	}

}
