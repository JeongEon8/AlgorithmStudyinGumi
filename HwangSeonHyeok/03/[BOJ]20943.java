import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
	static class Line{
		Long a, b;

		public Line(Long a, Long b) {
			this.a = a/gcd(a,b);
			this.b = b/gcd(a,b);
		}
		@Override
		public boolean equals(Object obj) {
			Line other = (Line) obj;
			if(this.a.equals(other.a)&&this.b.equals(other.b)) {
				return true;
			}
			return false;
		}
		@Override
		public int hashCode() {
			return Objects.hash(a);
		}
	}
	
	static long gcd(long a, long b) {
		if(b==0) return a;
		return gcd(b, a%b);
	}

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Map<Line, Long> people = new HashMap<>();
		long aZero = 0;
		long bZero = 0;
		for(int i = 0; i<n;i++) {
			String[] split = in.readLine().split(" ");
			long a = Integer.parseInt(split[0]);
			long b = Integer.parseInt(split[1]);
			if (a==0) {
				aZero++;
			}else if(b==0) {
				bZero++;
			}else {
				Line line = new Line(a,b);
				Long tmp = people.get(line);
				
				people.put(line, tmp==null? 1:tmp+1);
			}
		}
		long ans = aZero*bZero;
		long cnt = aZero+bZero;
		for(long l :people.values()) {
			ans += cnt*l;
			cnt+=l;
		}
		System.out.println(ans);
	}

}