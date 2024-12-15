# [백준- S1] 6064. 카잉 달력
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(lcm(N, M))$

## :round_pushpin: **Logic**
- `<M : N>`이 되기 위해서는 최대 M과 N의 최소공배수만큼이 걸림
- x를 고정시켜둔 후, y가 일치할 때까지만 비교하면 됨
- `해의 정보(몇 번째 해) % N == y`가 될 때까지 반복하면 됨
- ex) M = 10, N = 12, x = 3, y = 9일 때

| x | ny | y |
| --- | --- | --- |
| 3 | 3 | 3 % 12 = 3 |
| 3 | 13 | 13 % 12 = 1 |
| 3 | 23 | 23 % 12 = 11 |
| **3** | **33** | **33 % 12 = 9** |

```java
int ans = -1;

// x는 고정시키기
for (int i = x; i <= lcm; i += M) {
  int ny = i % N;
  if (ny == 0) ny = N;
  if (ny == y) {
    ans = i;
    break;
  }
}
```

## :black_nib: **Review**
진짜 순수하게 완탐으로 짰더니 시간초과가 발생했다. 생각을 좀 해야하는 문제였던..

## 📡**Link**
- https://www.acmicpc.net/problem/6064
