# [백준 - 실버 5] 19947.투자의 귀재 배주형
 
## ⏰ **time**
27분

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(3^N)$

## :round_pushpin: **Logic**
1. 연도마다 N-1 연도 값에 이자율을 곱해서 그중 최대값을 N에 저장한다.

```cpp
	for (int i = 1; i <= Y; i++) {
		for (int j = 0; j < 3; j++) {
			if (i - year[j] < 0) {
				continue;
			}
			DP[i] = max(DP[i], (int)(DP[i - year[j]] * rate[j]));
		}
	}
```

## :black_nib: **Review**
- [마지막 희망 **젤다의 전설 티어스 오브 더 킹덤 OST**](https://www.youtube.com/watch?v=a3y5RBoK-Sw&list=RDyaXD4nu7W88&index=2)
- 오늘은 젤다 왕눈 OST를 들으면서 알고를 풀었어요.
- 제가 아직 왕눈을 안 해봤는데, OST만 듣다보니 너무너무 하고 싶어졌어요.
- 취직하면 닌텐도부터 살테다 후하하
- 와, 여태 C++하면서 몰랐던 걸 깨달아버렸음.
- C++은 전역변수로 만들면 시스템 시작할 때 알아서 0으로 초기화를 해주는 거였음! (나만 몰랐냐며)

## 📡 Link
[https://www.acmicpc.net/problem/19947](https://www.acmicpc.net/problem/19947)
