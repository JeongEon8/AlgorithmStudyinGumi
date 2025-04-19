# [백준 - S4] 25972. 도미노 무너트리기

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
도미노의 좌표를 기준으로 정렬하는 도미노 클래스
```java
static class Domino implements Comparable<Domino> {
	int a, l;

	public Domino(int a, int l) {
		super();
		this.a = a;
		this.l = l;
	}

	@Override
	public int compareTo(Domino o) {
		return this.a - o.a;
	}

}
```
좌표를 기준으로 오름차순으로 정렬하고 이전 도미노와의 좌표 차이가 길이보다 크면 넘어지지 않으므로 무너트린 횟수를 증가시켜준다.
```java
Arrays.sort(dominos);
int ans = 1;
for (int i = 1; i < n; i++) {
	if (dominos[i].a > dominos[i - 1].a + dominos[i - 1].l) {
		ans++;
	}
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/25972
