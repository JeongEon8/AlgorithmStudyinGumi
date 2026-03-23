# [백준 - 실버 2] 16493. 최대 페이지 수

## ⏰ **time**
23분

## :pushpin: **Algorithm**
DP

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 모든 챕터 선택의 경우를 한번씩 살핀다.

```cpp
void func(int idx) {
    if (idx == N) {
        if (days <= D) ans = max(ans, val);
        return;
    }
    func(idx + 1);
    days += A[idx];
    val += P[idx];
    func(idx + 1);
    days -= A[idx];
    val -= P[idx];
}

```

## :black_nib: **Review**
- [닌텐도 음악 플레이리스트 믹스 | 텅 빈 머리를 채워주는 신나는 비디오 게임 음악](https://www.youtube.com/watch?v=IlwESW5wIUA)
- 이거 중간 중간에 포켓몬스터 노래가 나오는데요? 흑흑 디아루가 펄기아 하고 싶어요ㅠㅠㅠ

## 📡 Link
[https://www.acmicpc.net/problem/16493](https://www.acmicpc.net/problem/16493)
