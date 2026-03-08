# [백준 - 실버 1] 2502.떡 먹는 호랑이

## ⏰ **time**
23분

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 1일 = (1, 0), 2일 = (0, 1), 3일 = (1, 1), 4일 = (1, 2) ...
2. 위 와 같은 피보나치 수열을 이용하여 `xA + yB = K` 식의 계수를 계산한다.
3. B의 초기값을 DP[D]의 B계수를 K로 나눈값으로, A는 최소값인 1로 설정한다.
4. B는 1씩 줄이고, A는 1씩 증가시키며 K일 때의 값을 출력한다.
   * 이때, `xA + yB > K`라면 break해서 B를 줄인다.

```
	B = K / DP[D].second;
	A = 1;
	for (; B > A; B--) {
		for (A = 1; A < B; A++) {
			int calculate = DP[D].first * A + DP[D].second * B;
			if (calculate == K) {
				cout << A << '\n' << B << '\n';
				return 0;
			}
			else if (calculate > K) {
				break;
			}
		}
	}
```

## :black_nib: **Review**
- [마지막 희망 **젤다의 전설 티어스 오브 더 킹덤 OST**](https://www.youtube.com/watch?v=a3y5RBoK-Sw&list=RDyaXD4nu7W88&index=2)
- 오늘은 젤다 왕눈 OST를 들으면서 알고를 풀었어요.
- 제가 아직 왕눈을 안 해봤는데, OST만 듣다보니 너무너무 하고 싶어졌어요.
- 취직하면 닌텐도부터 살테다 후하하

## 📡 Link
[https://www.acmicpc.net/problem/2502](https://www.acmicpc.net/problem/2502)
