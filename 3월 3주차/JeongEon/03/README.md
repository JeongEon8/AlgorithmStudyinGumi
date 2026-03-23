# [백준 - 실버 2] 17271. 리그 오브 레전설 (Small) 

## ⏰ **time**
28분

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. M초 갱신시 기존 1초 경우의 수 + M초짜리 경우의 수

```cpp
    for(int i=1; i<=N; i++) {
        dp[i] = dp[i-1]; //1초짜리
        if(i >= M) dp[i] = (dp[i] + dp[i-M])%MOD; //1초짜리 + M초짜리
    }
```

## :black_nib: **Review**
- [닌텐도 음악 플레이리스트 믹스 | 텅 빈 머리를 채워주는 신나는 비디오 게임 음악](https://www.youtube.com/watch?v=IlwESW5wIUA)
- 이거 중간 중간에 포켓몬스터 노래가 나오는데요? 흑흑 디아루가 펄기아 하고 싶어요ㅠㅠㅠ

## 📡 Link
[https://www.acmicpc.net/problem/16493](https://www.acmicpc.net/problem/16493)
