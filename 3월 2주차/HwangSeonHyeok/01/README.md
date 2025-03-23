# [백준 - S5] 33520. 이진 딸기

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
15까지의 이진딸기를 미리 저장을 해둔다.
```java
for (int i = 0; i < 16; i++) {
	String str = "";
	for (int j = 0; j < 4; j++) {
		str += (i & 1 << (3 - j)) == 0 ? "V" : "딸기";
	}
	strawberry[i] = str;
}
```
1~15까지 반복되므로 각각의 수에 따라 나오는 수를 찾아서 구해놓은 딸기를 바로 출력한다.
```java
for (int tc = 0; tc < T; tc++) {
	int n = Integer.parseInt(in.readLine());
	n--;
	n %= 28;
	n++;
	if (n > 15) {
		int num = 30 - n;
		sb.append(strawberry[num]).append('\n');

	} else {
		sb.append(strawberry[n]).append('\n');
	}
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/22935
