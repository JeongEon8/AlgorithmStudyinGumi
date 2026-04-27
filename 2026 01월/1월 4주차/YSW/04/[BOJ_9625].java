import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_9625 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int aCount = 1;
		int bCount = 0;

		for (int i = 0; i < k; i++) {
			int tempA = bCount;
			int tempB = aCount + bCount;
			aCount = tempA;
			bCount = tempB;
		}

		System.out.print(aCount + " " + bCount);
	}
}