# [백준 - 실버 4] 25214. 크림파스타

## ⏰ **time**
20분

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 최솟값을 따로 저장한다.
2. 최댓값은 이전 값과 (추가값 - 최솟값)을 비교해서 저장한다.

```cpp
    for(int i=0; i < t; i++){
        cin >> x;
        if( i==0 ) {
            dp[0] = 0;
            min_num = x;}
        else {
            if ( x < min_num ) { min_num = x;}
            dp[i] = (x-min_num) > dp[i-1] ? (x-min_num) : dp[i-1];
        }
        cout << dp[i] << " " ;

    }
```

## :black_nib: **Review**
- [닌텐도 음악 플레이리스트 믹스 | 텅 빈 머리를 채워주는 신나는 비디오 게임 음악](https://www.youtube.com/watch?v=IlwESW5wIUA)
- 이거 중간 중간에 포켓몬스터 노래가 나오는데요? 흑흑 디아루가 펄기아 하고 싶어요ㅠㅠㅠ

## 📡 Link
[https://www.acmicpc.net/problem/16493](https://www.acmicpc.net/problem/16493)
