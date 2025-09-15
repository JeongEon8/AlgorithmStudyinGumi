
# [백준- S5] 1251. 단어 나누기

## ⏰  **time**
40분

## :pushpin: **Algorithm**
구현, 문자열

## ⏲️**Time Complexity**
O(N^3logN)

## :round_pushpin: **Logic**
- 단어를 세 부분으로 나눈 후, 각 부분을 뒤집어 합친다.
- ArrayList에 저장한 값들을 sort 한다.

```java
for (int i = 1; i < len - 1; i++) {
	for (int j = i + 1; j < len; j++) {
		// 단어를 세 부분으로 나눕니다.
		String part1 = word.substring(0, i);
		String part2 = word.substring(i, j);
		String part3 = word.substring(j, len);

		// 각 부분을 뒤집습니다.
		String reversedPart1 = new StringBuilder(part1).reverse().toString();
		String reversedPart2 = new StringBuilder(part2).reverse().toString();
		String reversedPart3 = new StringBuilder(part3).reverse().toString();

		// 뒤집은 부분을 합쳐서 결과를 저장합니다.
		results.add(reversedPart1 + reversedPart2 + reversedPart3);
	}
}
```

## :black_nib: **Review**
substring도 떠올리지 못한 바보..

## 📡**Link**
- https://www.acmicpc.net/problem/1251

