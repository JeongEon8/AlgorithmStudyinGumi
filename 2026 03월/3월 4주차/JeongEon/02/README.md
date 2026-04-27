# [백준 - 실버 4] 2491.수열

## ⏰ **time**
25분

## :pushpin: **Algorithm**
완전탐색

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 순서대로 돌며, 지금 내가 다음 나보다 큰지 작은지를 확인한다.
2. 첫 시작을 다음은 클것이다라고 가정하고 bigger로 시작한다.
   flag는 지금 나와 같은 수가 연속적일 때 그 번째 위치 (ex. 2 2 4 일 때 1번째 2의 위치를 flag에 저장)
3. 만약 지금 나보다 작다면, smaller로 옮기고 `cnt = ((n+1)-flag) + 1)`개수로 바꾼다.
4. 만약 지금 나보다 크다면, bigger를 호출하고, flag를 다음 위치로 옮긴다.
5. 만약 지금 나보다 동일하다면, flag는 같다.

```cpp
void isBigger(int n, int cnt, int flag) {
	max_cnt = max_cnt < cnt ? cnt : max_cnt;
	if (n >= N - 1) {
		return;
	}

	if (num[n] < num[n + 1]) {
		isBigger(n + 1, cnt + 1, n + 1);
	}
	else if (num[n] == num[n + 1]) {
		isBigger(n + 1, cnt + 1, flag);
	}
	else {
		isSmaller(n + 1, ((n+1) - flag) + 1, n + 1);
	}
}
```

## :black_nib: **Review**
- 오늘은 메가커피 복숭아 아이스티를 마시면서 알고리즘을 풀어요.
- 복숭아 아이스티가 3,000원이더군요! 세상에!
- 내 마음속 아이스티 가격은 2,000원이었는데, 어느새 이렇게 가격이 올랐어요...

## 📡 Link
[https://www.acmicpc.net/problem/2491](https://www.acmicpc.net/problem/2491)
