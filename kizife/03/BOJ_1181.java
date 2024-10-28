

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class BOJ_1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		 Set<String> set = new HashSet<>();
		
		for (int i = 0; i < n; i++) {
			String word = sc.next();
			
			set.add(word);
		}
		
	
		List<String> list = new ArrayList<>(set);
		
		 Collections.sort(list, (a, b) -> {
	            if (a.length() != b.length()) {
	                return a.length() - b.length();  // 길이 비교
	            }
	            return a.compareTo(b);  // 알파벳 비교
	        });

	        for (String word : list) {
	            System.out.println(word);
	        }
	}

}
