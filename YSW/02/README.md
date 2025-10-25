# [백준 - S1] 1522. 문자열 교환 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 브루트포스 알고리즘
- 슬라이딩 윈도우

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

문자열에서 a가 연속이 되면 되기 때문에 문자열에서 a의 개수만큼 길이로 잘랐을때 b가 가장 적게 들어 가는 부분이 교환의 회수가 최소값이 되기 때문에 문자열의 각 위치에서 a의 개수만큼의 길이로 자른 문자열의 현재 b의 개수가 가장 작은 값을 출력하게 작성했다.

```java
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'a')
				aCount++;
		}

		for (int i = 0; i < aCount; i++) {
			if (s.charAt(i) == 'b')
				bCurrentCount++;
		}
		result = bCurrentCount;

		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) == 'b')
				bCurrentCount--;

			if (s.charAt((i + aCount - 1) % s.length()) == 'b')
				bCurrentCount++;

			if (result > bCurrentCount)
				result = bCurrentCount;
		}
```

## :black_nib: **Review**

문제를 이해하는데 오래 걸렸다. 처음에는 문자 이동 시켜서 연결하는거라고 생각해서 예제문제의 입출력이 이해가 안되어서 문제를 푸는데 오래걸렸고, 해당 위치의 문자끼리 자리를 교환할 수 있다는 걸 알고 풀수 있게 되었다. 문제를 이해를 잘 할 수 있도록 노력해야겠다.

## 📡**Link**

https://www.acmicpc.net/problem/1522
