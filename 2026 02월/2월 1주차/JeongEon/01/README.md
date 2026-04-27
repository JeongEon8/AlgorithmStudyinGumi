# [백준 - 실버 3] 1004. 어린 왕자

## ⏰ **time**
15분

## :pushpin: **Algorithm**
구현

## ⏲️ **Time Complexity**
$O(T \times N)$

## :round_pushpin: **Logic**
1. 출발점 `(x1, y1)`과 도착점 `(x2, y2)`를 입력받는다.
2. 각 행성계는 중심 `(cx, cy)`와 반지름 `r`로 주어진다.
3. 출발점과 도착점이 각각 **해당 원 내부에 있는지**를 판단한다.
   * 점과 원의 거리 ≤ 반지름 → 원 내부
4. 두 점 중 **하나만 원 내부에 있는 경우**, 해당 원의 경계를 한 번 통과하게 된다.
5. 이 조건을 만족하는 원의 개수를 세어 출력한다.
```
for 각 원:
    start_in = (출발점과 중심의 거리 <= r)
    end_in   = (도착점과 중심의 거리 <= r)

    if start_in != end_in:
        cnt++
```

## :black_nib: **Review**
- 어린왕자 려욱 노래 들으면서 풀면 기분이 조크든요 ^..^

## 📡 Link
[https://www.acmicpc.net/problem/1004](https://www.acmicpc.net/problem/1004)
