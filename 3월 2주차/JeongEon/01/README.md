# [백준 - 실버 3] 19941. 햄버거 분배

## ⏰**time**
15분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(N \times K)$

## :round_pushpin: **Logic**

1. 테이블 상태를 문자열로 입력받는다.

   * `P` : 사람
   * `H` : 햄버거
2. 왼쪽부터 탐색하면서 `P`를 발견하면 해당 사람이 먹을 햄버거를 찾는다.
3. 탐색 범위는 `i-k`부터 `i+k`까지이다.
4. 범위 안에서 **가장 왼쪽에 있는 햄버거**를 찾으면:

   * 해당 햄버거를 먹었다고 표시 (`'-'`)
   * `cnt++`
5. 한 번 먹은 햄버거는 다시 먹을 수 없도록 표시한다.
6. 모든 위치를 확인한 뒤 먹을 수 있는 최대 햄버거 개수를 출력한다.

```
for i = 0 ~ n-1:
    if arr[i] == 'P':
        for j = i-k ~ i+k:
            if 범위 안이고 arr[j] == 'H':
                arr[j] = '-'
                cnt++
                break
```

## :black_nib: **Review**
-

## 📡 Link
[https://www.acmicpc.net/problem/19941](https://www.acmicpc.net/problem/19941)
