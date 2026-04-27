import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] split = br.readLine().split(" ");
		int E = Integer.parseInt(split[0]);
		int S = Integer.parseInt(split[1]);
		int M = Integer.parseInt(split[2]);

		// 1부터 증가시키면서 비교, 0이면 최대값으로 변환
		int year = 1;
		while(true) {
			
			int e = year % 15;
            int s = year % 28;
            int m = year % 19;
            
            if (e == 0) e = 15;
            if (s == 0) s = 28;
            if (m == 0) m = 19;
            
			if (e == E && s == S && m == M) {
				System.out.println(year);
				break;
			}
			
			year++;
		}
	}

}