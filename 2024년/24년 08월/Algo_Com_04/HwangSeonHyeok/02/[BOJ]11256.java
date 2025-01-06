import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static int getGCD(int a, int b) {
		if(b==0) {
			return a;
		}
		return getGCD(b,a%b);
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		String[] split = in.readLine().split(" ");
		List<Integer> list = new ArrayList<>();
		int gcd;
		int r = Integer.parseInt(split[0]);
		int g = Integer.parseInt(split[1]);
		if(r<g) {
			gcd = getGCD(g,r);
		}else {
			gcd = getGCD(r,g);
		}
		for(int i = 1; i<=Math.sqrt(gcd); i++) {
			if(gcd%i==0) {
				sb.append(i + " "+ (r/i) + " " + (g/i) + "\n");
				list.add(i);
			}
		}
		for(int i =0; i<list.size();i++) {
			if(list.get(i)==Math.sqrt(gcd))continue;
			int cd = gcd/list.get(i);
			sb.append(cd + " "+ (r/cd) + " " + (g/cd) + "\n");
		}
		System.out.println(sb.toString());
	}

}