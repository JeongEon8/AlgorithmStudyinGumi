# [백준 - 실버 2] 11722.가장 긴 감소하는 부분 수열

## ⏰ **time**
15분

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(NlogN))$

## :round_pushpin: **Logic**
1. dp[i] = max(dp[i], dp[j] + 1)
```cpp
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < i; j++) {
			if (arr[i] < arr[j]) {
				dp[i] = max(dp[i], dp[j] + 1);
			}
		}
	}
```

## :black_nib: **Review**
- 그거 아시나요? C++에서는 `memset`이라는 초기화 함수가 있어요.
- 근데 얘기 char 아니면 0으로 채우기만 돼요!
- 즉, 1이나 number를 넣게 되면 얘가 쓰레기 값으로 초기화 해주는거죠..ㅎ
- 어떻게 알았냐고요? 저도 알고 싶지 않았어요...
- 앞으로 number로 초기화 한다면 `fill_n`을 활용합시다~

## 📡 Link
[https://www.acmicpc.net/problem/11722](https://www.acmicpc.net/problem/11722)
