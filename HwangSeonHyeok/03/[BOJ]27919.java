import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String V = in.readLine();
		int uc = 0;
		int dp = 0;
		for(int i = 0; i<V.length();i++) {
			char c = V.charAt(i);
			if(c=='U'||c=='C')
				uc++;
			else if(c=='D'||c=='P') {
				dp++;
			}
		}
		String ans = "";
		if(uc>dp/2+dp%2) {
			ans+="U";
		}
		if(dp>0) {
			ans+="DP";
		}
		System.out.println(ans);
		

	}

}