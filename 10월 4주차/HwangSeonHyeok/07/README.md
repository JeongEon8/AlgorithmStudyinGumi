# [백준 - G4] 2138. 전구와 스위치

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 그리디 알고리즘

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

i번을 클릭하면 i-1이하의 전구들은 더이상 변할수 없으므로 i-1의 형태를 맞춰는 형식으로 진행하면된다. 이 경우 0번 스위치는 i-1로 판단할 수 없으므로 0번은 클릭하는 경우 클릭하지 않고 시작하는 경우 둘 다 봐줘야한다.

```java
static void click(int idx) {
	start[idx - 1] ^= 1;
	start[idx] ^= 1;
	if (idx + 1 < n)
		start[idx + 1] ^= 1;
}

static int solve() {
	int result = 0;
	for (int i = 1; i < n; i++) {
		if (start[i - 1] != to[i - 1]) {
			click(i);
			result++;
		}
	}
	if (start[n - 1] == to[n - 1]) {
		return result;
	}
	return -1;

}

```

## :black_nib: **Review**

의외로 그리디로 풀리는 문제였다.

## 📡**Link**

https://www.acmicpc.net/problem/2138
