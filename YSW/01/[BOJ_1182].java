import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ_1182 {
	public static int S;
	public static int count = 0;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		int N = Integer.parseInt(strArr[0]);
		S = Integer.parseInt(strArr[1]);
		int[] arr = new int[N];
		ArrayList<Integer> result = new ArrayList<Integer>();
		strArr = br.readLine().split(" ");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(strArr[i]);
		}
		
		subSet(arr, result, 0);
		System.out.println(count);
	}
	
	public static void subSet(int[] arr, ArrayList<Integer> result, int index) {
		if(index == arr.length) {
			int sum = 0;
			if(result.size() == 0) {
				return;
			}
			
			for (int i = 0; i < result.size(); i++) {
				sum += result.get(i);
			}
			if(sum == S) {
				count++;
			}
			
			return;
		}
		
		subSet(arr, result, index + 1);
		
		result.add(arr[index]);
		subSet(arr, result, index + 1);
		result.remove(result.size() - 1);
	}
}