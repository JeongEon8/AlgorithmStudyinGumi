# [백준 - G5] 27396. 문자열 변환과 쿼리

## ⏰ **time**

25분

## :pushpin: **Algorithm**

- 자료 구조
- 문자열

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
각 char마다 어떤 char로 바뀌는지 배열을 만들어서 맵핑해준다. 아스키코드를 그대로 사용하기위해 배열의 크기는 128로 사용하였다.
```java
static void changeChar(char src, char dest) {
	for (int i = 0; i < 128; i++) {
		if (charMap[i] == src) {
			charMap[i] = dest;
		}
	}
}
for (int i = 0; i < n; i++) {
	split = in.readLine().split(" ");
	int cmd = Integer.parseInt(split[0]);
	if (cmd == 1) {
		char src = split[1].charAt(0);
		char dest = split[2].charAt(0);
		changeChar(src, dest);
	} else {
		for (int j = 0; j < str.length(); j++) {
			sb.append(charMap[str.charAt(j)]);
		}
		sb.append("\n");
	}
}
```

## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/27396
