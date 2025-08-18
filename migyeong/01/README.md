
# [백준- S5] 1316. 그룹 단어 체커

## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**

- 이전 값이 지금과 같은지, 다르다면 이미 언급된적 있는 알파벳인지 체크

```java
for (int j = 1; j < word.length(); j++) {
	char currentChar = word.charAt(j);
	if (currentChar != previousChar) {
		if (alpha[currentChar - 'a']) {
			isGroupWord = false;
			break;
		}
		alpha[currentChar - 'a'] = true;
	}
	previousChar = currentChar;
}
```

## :black_nib: **Review**
- 문제 풀 시간 부족 이슈


## 📡**Link**
- https://www.acmicpc.net/problem/1316

