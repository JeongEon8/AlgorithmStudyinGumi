# [백준 - 실버 3] 17212. 달나라 토끼를 위한 구매대금 지불 도우미

## ⏰ **time**
30분

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. N-1원을 최소 개수의 동전으로 지불한 뒤 1원 동전을 추가 지불
2. N-2원을 최소 개수의 동전으로 지불한 뒤 2원 동전을 추가 지불
3. N-5원을 최소 개수의 동전으로 지불한 뒤 5원 동전을 추가 지불
4. N-7원을 최소 개수의 동전으로 지불한 뒤 7원 동전을 추가 지불

```cpp
	for (int i = 1; i < 100001; i++) {
		dp[i] = dp[i - 1];
		if (i > 1) dp[i] = min(dp[i], dp[i - 2]);
		if (i > 4) dp[i] = min(dp[i], dp[i - 5]);
		if (i > 6) dp[i] = min(dp[i], dp[i - 7]);
		dp[i]++;
	}
```

## :black_nib: **Review**
- [닌텐도 음악 플레이리스트 믹스 | 텅 빈 머리를 채워주는 신나는 비디오 게임 음악](https://www.youtube.com/watch?v=IlwESW5wIUA)
- 오늘은 마리오 노래를 틀고 했는데요? 마리오 64가 하고 싶어졌어요...
- 흑흑 자소서 말구 행복 DS 생활하고 싶어요ㅠ

## 📡 Link
[https://www.acmicpc.net/problem/17212](https://www.acmicpc.net/problem/17212)
