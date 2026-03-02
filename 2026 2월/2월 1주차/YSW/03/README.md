# [백준 - S3] 30046. HJS (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 브루트포스 알고리즘
- 많은 조건 분기

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

세 개의 문자열은 문자 H, J, S로만 이루어져 있으며, 각 문자에 1부터 9까지의 서로 다른 숫자를 할당할 수 있다.

문제의 목표는 어떤 숫자 배정 (H, J, S)가 존재해서 첫 번째 문자열 < 두 번째 문자열 < 세 번째 문자열의 사전식 비교 결과가 성립하는지를 판단하는 것이다.

이를 위해 H, J, S에 서로 다른 값(1~9)을 모든 경우에 대해 시도한다. 각 배정에 대해 문자열의 같은 위치 문자들을 숫자로 변환하여 앞에서부터 비교하고, 처음으로 값이 달라지는 위치에서 대소 관계를 결정한다.

만약 어떤 배정이라도 inputs[0] < inputs[1] 이고 inputs[1] < inputs[2]를 동시에 만족하면 조건이 성립하므로 "HJS! HJS! HJS!"를 출력하고 종료한다.

모든 경우를 시도해도 조건을 만족하지 못하면 "Hmm..."을 출력한다.

```java
		for (int h = 1; h <= 9; h++) {
			for (int j = 1; j <= 9; j++) {
				if (h == j)
					continue;
				for (int s = 1; s <= 9; s++) {
					if (h == s || j == s)
						continue;

					if (compare(inputs[0], inputs[1], h, j, s) < 0 && compare(inputs[1], inputs[2], h, j, s) < 0) {
						System.out.println("HJS! HJS! HJS!");
						return;
					}
				}
			}
		}

	private static int compare(String s1, String s2, int h, int j, int s) {
		for (int i = 0; i < s1.length(); i++) {
			int v1 = getVal(s1.charAt(i), h, j, s);
			int v2 = getVal(s2.charAt(i), h, j, s);

			if (v1 < v2)
				return -1;
			if (v1 > v2)
				return 1;
		}
		return 0;
	}

	private static int getVal(char c, int h, int j, int s) {
		if (c == 'H')
			return h;
		if (c == 'J')
			return j;
		return s;
	}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/30046