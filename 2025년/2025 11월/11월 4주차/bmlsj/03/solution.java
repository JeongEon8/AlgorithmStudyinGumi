import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] split = br.readLine().split(" ");
		
		int[] nums = new int[N];
		Set<Integer> set = new TreeSet<>();
		for(int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(split[i]);
			set.add(nums[i]);
		}
		
		StringBuilder sb = new StringBuilder();
        for (int n : set) {
            sb.append(n).append(" ");
        }

        System.out.println(sb.toString());
		
	}

}
