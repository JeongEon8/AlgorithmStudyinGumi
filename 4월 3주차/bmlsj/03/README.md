# [PGS - lv2] 03. 영어 끝말잇기

## ⏰**time**

40분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 첫 번째 단어를 set에 저장하고 시작
2. 두 번째 단어부터 순회하면서 검사
   - 이전 단어의 마지막 글자와 현재 단어의 첫 글자가 같은지 확인
   - 현재 단어가 이미 나온 단어인지(set으로 중복 체크)
3. 위 조건 중 하나라도 만족하지 않으면 탈락
   - 사람 번호: `(i % n) + 1`
   - 차례: `(i / n) + 1`
4. 문제가 없으면 현재 단어를 set에 추가하고 계속 진행
5. 끝까지 탈락자가 없으면 [0, 0] 반환

```java
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
```

## :black_nib: **Review**

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/12981>
