package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class 단어정렬 {
	public static void main(String[] args) throws Exception, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		// 중복 제거
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}

		ArrayList<String> list = new ArrayList<>(set);

		// System.out.println(list);

		// 이제 정렬할거임
		// 1. 길이 짧은 순으로 -> length 쓰면 안되려나
		// 허걱 comparator 메서드를 정의해야함
		// Comparator.sort(list, (a,b) -> a-b);
		// list를 정렬할건데 a랑 b랑 비교할거임
		// a - b < 0 -> a < b -> a가 b보다 작으면 a가 먼저와야함
		// a - b > 0 -> a > b -> a 가 b보다 크면 b가 먼저 와야함
		// comparator 는 a,b중에 뭘 앞에 둘지 정하는 거고, 기준은 내가 정함
		// a - b -> a를 b보다 앞에 둬도됨? -> a가 음수라면 -> ㅇㅇ 앞에둬도됨

		Collections.sort(list, (a, b) -> {
			if (a.length() == b.length()) {
				return a.compareTo(b);
			}
			return a.length() - b.length();
		});

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}
}
