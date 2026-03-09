# [백준 - 실버 3] 17175.피보나치는 지겨웡~
 
## ⏰ **time**
11분

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. N = 0 -> 1, N = 1 -> 1, N = 2 -> 3, N = 3 -> 5, N = 4 -> 9 ...
2. `N = (N-1) + (N-2) + 1`

```cpp
	for (int i = 2; i <= N; i++) {
		DP[i] = DP[i - 1] + DP[i - 2] + 1;
	}
```

## :black_nib: **Review**
- [마지막 희망 **젤다의 전설 티어스 오브 더 킹덤 OST**](https://www.youtube.com/watch?v=a3y5RBoK-Sw&list=RDyaXD4nu7W88&index=2)
- 오늘은 젤다 왕눈 OST를 들으면서 알고를 풀었어요.
- 제가 아직 왕눈을 안 해봤는데, OST만 듣다보니 너무너무 하고 싶어졌어요.
- 취직하면 닌텐도부터 살테다 후하하
- 실버라고 단순하게 카운트만 하면 시간초과가 난다...
- 그렇다고 범위 생각 안하고 제출하면 안된다...
- 또, 문제 출력 생각 안하고 나누기 안하면 안된다...

## 📡 Link
[https://www.acmicpc.net/problem/17175](https://www.acmicpc.net/problem/17175)
