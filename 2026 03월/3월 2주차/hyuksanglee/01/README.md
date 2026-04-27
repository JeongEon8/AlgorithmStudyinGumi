# [백준 - 실버 1] 2583. 영역 구하기

## ⏰**time**

60분

## :pushpin: **Algorithm**

- dfs, 우선순위 큐

## :round_pushpin: **Logic**

1. 두번째줄부터 해당되는 칸에 체크 해준다
2. dfs를 탐색하면서 체크되어 있지 않은 곳을 탐색하고 개수를 우선순위 큐에 저장
3. 큐의 개수와 큐에서 하나씩 뽑아서 출력


``` kotlin
fun dfs(i: Int, j: Int): Int {
    check[i][j] = true
    var area = 1

    for (d in 0..3) {
        val ni = i + DI[d]
        val nj = j + DJ[d]

        if (ni in 0 until M && nj in 0 until N) {
            if (!check[ni][nj]) {
                area += dfs(ni, nj)
            }
        }
    }
    return area
}
```
## 📡 Review
- 코틀린으로 푸니깐 너무 어려워요

## 📡 Link

https://www.acmicpc.net/problem/2583
