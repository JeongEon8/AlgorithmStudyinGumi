# [백준- S3] 2559. 수열
 
## ⏰  **time**
15분

## :pushpin: **Algorithm**
누적합

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- i번째까지 온도 합 구하기
- i일 최대 온도 합: `temperatures[i] = temperatures[i - 1] + Integer.parseInt(st.nextToken())`
```java
for (int i = 1; i <= N; i++) {
    temperatures[i] = temperatures[i - 1] + Integer.parseInt(st.nextToken());
}

int maxTemperatures = INF;
for (int i = K; i <= N; i++) {
    maxTemperatures = Math.max(maxTemperatures, temperatures[i] - temperatures[i - K]);
}
System.out.println(maxTemperatures);
```

## :black_nib: **Review**
최댓값이 음수가 될 수 있다는 것도 생각하자

## 📡**Link**
- https://www.acmicpc.net/problem/2559
