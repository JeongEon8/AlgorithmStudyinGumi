# [백준 - S2] 15729. 방탈출

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
버튼을 누르면 누른 버튼과 오른쪽만 영향을 끼친다  
즉 지금 버튼이 암호와 다르다면 누르고 넘어가면 이후에 이 버튼의 상태가 변하지않으므로 답이된다.
버튼을 누르는 횟수만 카운팅하면된다.

```java
int ans = 0;
for (int i = 0; i < n; i++) {
	if (button[i] != password[i]) {
		ans++;
		button[i] ^= 1;
		if (i + 1 < n)
			button[i + 1] ^= 1;
		if (i + 2 < n)
			button[i + 2] ^= 1;
	}
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/15729
