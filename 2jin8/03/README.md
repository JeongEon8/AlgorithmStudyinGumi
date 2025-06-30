# [백준- G5] 3020. 개똥벌레
 
## ⏰  **time**
1시간

## :pushpin: **Algorithm**
누적합

## ⏲️**Time Complexity**
$O(N + H)$

## :round_pushpin: **Logic**
- 차분 배열 & 누적합 사용해서 해당 구간에서 제거해야 하는 장애물의 수 계산
- `[L, R)` 구간에 특정 값을 더할 때
  - `diff[L]++`
  - `diff[R]--`
- 누적합 계산
  - `count[i] = count[i - 1] + diff[i]`
```java
diff = new int[H + 1];
for (int i = 0; i < N; i++) {
    int h = Integer.parseInt(br.readLine());
    if (i % 2 == 0) {
        diff[0]++;
        diff[h]--;
    } else {
        diff[H - h]++;
        diff[H]--;
    }
}

// 누적합 구하기
count = new int[H];
count[0] = diff[0];
for (int i = 1; i < H; i++) {
    count[i] = count[i - 1] + diff[i];
}
```

## :black_nib: **Review**
무식하게 이중 for 문 돌리니까 시간초과떴다. 클로드가 차분 배열을 알려줬는데 개념 다시 봐야겠다 헷갈린다

## 📡**Link**
- https://www.acmicpc.net/problem/3020
