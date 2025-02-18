# [백준 - 실버 3] 15652. N과 M(4)
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
중복 조합, 백트래킹

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. M개의 숫자 조합은 DFS로 찾는다.
2. M개의 숫자를 모두 선택한 경우 탐색을 종료한다.
```java
if (cnt == M) {
    for(int i = 0; i < M; i++) {
        sb.append(num[i]).append(" ");
    }
    sb.append("\n");
    return;
}

for (int i = start; i < N + 1; i++) {
    num[cnt] = i;
    combi(i, cnt + 1); 
}
```

## :black_nib: **Review**
- 사랑해요 실버

## 📡 Link
https://www.acmicpc.net/problem/15652
