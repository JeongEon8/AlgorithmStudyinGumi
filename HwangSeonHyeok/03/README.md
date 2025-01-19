# [백준 - S2] 1182. 부분수열의 합

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 브루트포스 알고리즘
- 백트래킹

## ⏲️**Time Complexity**

$O(2^N)$

## :round_pushpin: **Logic**
이전 step에서 뭔가 골랐을 때 그 합이 s일때를 카운팅한다.

```java
static void solve(int step, int sum, boolean selected) {
	if (selected && sum == s)
		ans++;
	if (step == n) {
		return;
	}
	if (sum >= s && arr[step] > 0)
		return;
	solve(step + 1, sum + arr[step], true);
	solve(step + 1, sum, false);

}
```

## :black_nib: **Review**
뭔가 로직이 만족스럽진 않다..

## 📡**Link**

https://www.acmicpc.net/problem/1182
