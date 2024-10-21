import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		long n = Integer.parseInt(s);
		n--;
		
		s = br.readLine();
		StringTokenizer st = new StringTokenizer(s);
		List<Long> road = new ArrayList<>(); 
		while(st.hasMoreTokens()) {
			road.add((long) Integer.parseInt(st.nextToken()));
		}
		
		
		s = br.readLine();
		st = new StringTokenizer(s);
		List<Integer> gas = new ArrayList<>(); 
		while(st.hasMoreTokens()) {
			gas.add(Integer.parseInt(st.nextToken()));
		}
		long gprice = 10001;
		long total = 0;
		long dis = 0;
		for (int i = 0; i < n; i++) {
			if (gas.get(i) < gprice) {
				gprice = gas.get(i);
				total += gprice * road.get(i);
			}
			else {
				total += gprice * road.get(i);
			}
		}
		System.out.println(total);
	}
}
