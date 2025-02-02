# [백준- S2] 6603. 로또
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(2ⁿ)$

## :round_pushpin: **Logic**
- 순서가 중요하지 않음 => 조합
- n개의 수 중 6개를 골라 숫자 조합을 만들면 됨
```java
// 순서 중요 X => 조합
static void makeLotto(int depth, int start) {
  // 6개를 다 고르면 숫자 조합 완성
  if (depth == M) {
    for (int l : lotto) {
      sb.append(l).append(" ");
    }
    sb.append("\n");
    return;
  }

  for (int i = start; i < N; i++) {
    lotto[depth] = arr[i];
    makeLotto(depth + 1, i + 1);
  }
}
```

## :black_nib: **Review**
오랜만에 조합! `start` 변수 까먹지 말자

## 📡**Link**
- https://www.acmicpc.net/problem/6603
