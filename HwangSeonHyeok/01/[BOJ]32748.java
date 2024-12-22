import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[] f = new int[10];
		int[] inverseF = new int[10];
		String[] split = in.readLine().split(" ");
		for(int i = 0; i<10;i++) {
			int num = Integer.parseInt(split[i]);
			f[i] = num;
			inverseF[num] = i;
		}
		split = in.readLine().split(" ");
		String A = "";
		String B = "";
		for(int i = 0; i<split[0].length();i++) {
			char c = split[0].charAt(i);
			A+= Integer.toString(inverseF[c-'0']);
		}
		for(int i = 0; i<split[1].length();i++) {
			char c = split[1].charAt(i);
			B+= Integer.toString(inverseF[c-'0']);
		}
		int AB = Integer.parseInt(A)+Integer.parseInt(B);
		String stringAB = Integer.toString(AB);
		String ans = "";
		for(int i = 0; i < stringAB.length();i++) {
			char c = stringAB.charAt(i);
			ans+= Integer.toString(f[c-'0']);
		}
		System.out.println(ans);
	}

}