import java.util.*;
class Solution {
    public static int[] solution(int n, String[] words) {

		HashSet<String> set = new HashSet<>();
		set.add(words[0]);

		for (int i = 1; i < words.length; i++) {

			String prev = words[i - 1];
			String curr = words[i];

			if (set.contains(curr) || prev.charAt(prev.length() - 1) != curr.charAt(0)) {
				return new int[] { (i % n) + 1, (i / n) + 1 };
			}

			set.add(curr);

		}

		return new int[] { 0, 0 };
	}
}