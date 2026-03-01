# [백준 - 실버 5] 2828. 사과 담기 게임 

## ⏰**time**
10분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(J \times N)$

## :round_pushpin: **Logic**
1. 바구니의 초기 위치를 `[start, end] = [1, M]`으로 설정한다.
2. 사과가 떨어지는 위치 `x`를 입력받는다.
3. 만약 `x`가 현재 바구니 범위 안에 있다면 이동하지 않는다.
4. 범위 밖에 있다면:
   * `x < start` → 바구니를 왼쪽으로 한 칸씩 이동
   * `x > end` → 바구니를 오른쪽으로 한 칸씩 이동
5. 이동할 때마다 `cnt++`로 이동 횟수를 증가시킨다.
6. 모든 사과에 대해 반복 후 총 이동 횟수를 출력한다.
```cpp
start = 1
end = M

for each apple x:
    while x not in [start, end]:
        if x < start:
            start--, end--, cnt++
        else:
            start++, end++, cnt++
```

## :black_nib: **Review**
-

## 📡 Link
[https://www.acmicpc.net/problem/2828](https://www.acmicpc.net/problem/2828)
