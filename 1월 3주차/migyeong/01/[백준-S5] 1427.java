import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1427 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split("");
		
		int[] num = new int[split.length];
		
		for(int i = 0; i < split.length; i++) {
			num[i] = Integer.parseInt(split[i]);
		}
		
		Arrays.sort(num);
		
		for(int i = num.length-1; i >= 0; i--) {
			System.out.print(num[i]);
		}
	}
}
