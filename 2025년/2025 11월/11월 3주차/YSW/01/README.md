# [백준 - G5] 25542. 약속 장소 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 구현
- 문자열
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(26*N^2*L^2)$

## :round_pushpin: **Logic**

words 배열에 들어 있는 후보 가게 이름들 중 하나를 base 문자열로 선택한다.
먼저 base 문자열이 모든 후보 문자열과 비교했을 때, 각 후보와의 문자 차이(Hamming distance)가 1 이하인지 확인한다. 모든 후보와의 차이가 1 이하라면 base가 조건을 만족하므로 정답이 된다.
만약 base가 조건을 만족하지 못하면, base의 각 위치를 A~Z로 하나씩 바꿔가며 새로운 문자열 candidate를 생성한다. 각 candidate 역시 모든 후보 문자열과의 차이가 1 이하인지 검사한다.
이 과정에서 조건을 만족하는 문자열을 찾으면, 그 문자열을 출력한다.
모든 base와 모든 candidate를 검사해도 조건을 만족하는 문자열이 없다면, "CALL FRIEND"를 출력한다.

```java
		for (int i = 0; i < N; i++) {
			String base = words[i];

			if (isValidCandidate(base)) {
				System.out.println(base);
				return;
			}

			for (int pos = 0; pos < L; pos++) {
				for (char c = 'A'; c <= 'Z'; c++) {
					if (c == base.charAt(pos)) {
						continue;
					}

					StringBuilder sb = new StringBuilder(base);
					sb.setCharAt(pos, c);
					String candidate = sb.toString();

					if (isValidCandidate(candidate)) {
						System.out.println(candidate);
						return;
					}
				}
			}
		}

	public static boolean isValidCandidate(String word) {
		for (int i = 0; i < N; i++) {
			if (hammingDistance(word, words[i]) > 1) {
				return false;
			}
		}
		return true;
	}

	public static int hammingDistance(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i)) {
				count++;
			}
		}
		return count;
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/25542
