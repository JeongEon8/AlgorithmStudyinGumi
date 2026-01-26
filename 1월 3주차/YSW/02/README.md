# [백준 - S2] 23304. 아카라카 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 문자열
- 재귀

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

문자열을 입력받아 먼저 전체 문자열이 팰린드롬인지 확인한다. i번째 문자와 (길이 − 1 − i)번째 문자가 하나라도 다르면 false를 반환한다.
전체가 팰린드롬이라면, 문자열을 절반으로 나누어 접두사와 접미사를 만든다(길이가 홀수인 경우 가운데 문자는 제외한다).
접두사와 접미사 각각에 대해 재귀적으로 같은 검사를 수행하며, 길이가 1인 문자열은 항상 아카라카 팰린드롬으로 판단한다. 
모든 단계에서 조건을 만족하면 true를 반환한다.

```java
		int len = input.length();

		if (len == 1) {
			return true;
		}

		boolean result = false;
		if (len >= 2) {

			for (int i = 0; i < len / 2; i++) {
				if (input.charAt(i) != input.charAt(len - 1 - i)) {
					return false;
				}
			}

			String prefix = input.substring(0, len / 2);
			String suffix = input.substring(len / 2 + (len % 2 == 0 ? 0 : 1), len);

			if (isAkarakaPalindrome(prefix) && isAkarakaPalindrome(suffix)) {
				result = true;
			}
		}

		return result;
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/23304
