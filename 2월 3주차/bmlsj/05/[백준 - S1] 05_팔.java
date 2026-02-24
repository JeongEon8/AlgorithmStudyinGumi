import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		char[] L = split[0].toCharArray();
		char[] R = split[1].toCharArray();
		
		if (L.length != R.length) {
            System.out.println(0);
            return;
        }
		
		int ans = 0;
		for(int i = 0; i < L.length; i++) {
			if (L[i] == R[i]) {
		        if (L[i] == '8') {
		            ans++;
		        }
		    } else {
		        break;
		    }
		}
		System.out.println(ans);

	}

}