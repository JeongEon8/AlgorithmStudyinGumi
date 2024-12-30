# [백준 - S5] 10384. 팬그램

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 문자열

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
26크기의 int배열에 알파벳의 갯수를 센다.  
가장 적게나온 알파벳의 수가 팬그램의 수이다.

```java
	String str = in.readLine();
	for (int i = 0; i < str.length(); i++) {
		char c = str.charAt(i);
		if (c >= 'a' && c <= 'z') {
			alphabet[c - 'a']++;
		} else if (c >= 'A' && c <= 'Z') {
			alphabet[c - 'A']++;
		}
	}
	int min = 3;
	for (int i = 0; i < 26; i++) {
		if (alphabet[i] < min) {
			min = alphabet[i];
		}
	}

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/10384
