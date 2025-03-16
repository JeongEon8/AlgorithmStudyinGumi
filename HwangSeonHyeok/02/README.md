# [백준 - S5] 33520. 초코바 만들기

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
가로, 세로 중 작은쪽의 가장 긴 길이와 긴 쪽의 가장 긴 길이인 틀의 넓이를 구한다.

```java
for (int i = 0; i < n; i++) {
	String[] split = in.readLine().split(" ");
	int a = Integer.parseInt(split[0]);
	int b = Integer.parseInt(split[1]);
	w = Math.max(w, Math.max(a, b));
	h = Math.max(h, Math.min(a, b));
}
System.out.println(w * h);
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/33520
