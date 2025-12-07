import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] nums = new String[n];
		for (int i = 0; i < n; i++) {
			nums[i] = br.readLine();
		}

		int start = 0;
		HashSet<Integer> set = new HashSet<Integer>();

		while (set.size() != n) {
			++start;
			set.clear();
			for (int i = 0; i < n; i++) {
				String split = nums[i].substring(nums[i].length() - start);
				set.add(Integer.parseInt(split));
			}

		}

		System.out.println(start);
	}
}