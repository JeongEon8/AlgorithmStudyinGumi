# [백준 - 실버 3] 9657.돌 게임 3

## ⏰ **time**
16분

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. N = 1 -> Sk, N = 2 -> CY, N = 3 -> SK, N = 4 -> SK, N = 5 -> CY ...
2. `(N-1)`, `(N-3)`, `(N-4)`가 모두 동일한 사람이 이기면 `N`번째는 다른 사람이 이긴다.

```cpp
	for (int i = 5; i <= N; i++) {
		if (DP[i - 1] == 1 && DP[i - 3] == 1 && DP[i - 4] == 1) {
			DP[i] = 0;
		}
		else {
			DP[i] = 1;
		}
	}
```

## :black_nib: **Review**
- [마지막 희망 **젤다의 전설 티어스 오브 더 킹덤 OST**](https://www.youtube.com/watch?v=a3y5RBoK-Sw&list=RDyaXD4nu7W88&index=2)
- 오늘은 젤다 왕눈 OST를 들으면서 알고를 풀었어요.
- 제가 아직 왕눈을 안 해봤는데, OST만 듣다보니 너무너무 하고 싶어졌어요.
- 취직하면 닌텐도부터 살테다 후하하

## 📡 Link
[https://www.acmicpc.net/problem/9657](https://www.acmicpc.net/problem/9657)
