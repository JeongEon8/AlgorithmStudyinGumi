# [백준 - 골드 3] 1644. 소수의 연속합

## ⏰**time**

38분

## :pushpin: **Algorithm**

- 에라토스테네스의 체
- 투 포인터 (슬라이딩 윈도우)

## ⏲️**Time Complexity**

- 소수 판별: $O(N \log \log N)$
- 연속 합 계산: $O(P)$ (P = N 이하 소수 개수)  
  → 전체적으로 $O(N \log \log N)$

## :round_pushpin: **Logic**

1. `isPrime[0]`, `isPrime[1]`을 제외하고 `true`로 초기화한 뒤, 에라토스테네스의 체로 2부터 $\sqrt{N}$까지의 배수를 지우며 2~N 사이의 모든 소수를 구합니다.
```java
boolean[] isPrime = new boolean[N + 1];
Arrays.fill(isPrime, true);
isPrime[0] = isPrime[1] = false;
for (int i = 2; i * i <= N; i++) {
    if (!isPrime[i]) continue;
    for (int j = i * i; j <= N; j += i) {
        isPrime[j] = false;
    }
}
```

2. 소수들만 `primes` 리스트에 순서대로 담습니다.
```java
List<Integer> primes = new ArrayList<>();
for (int i = 2; i <= N; i++) {
    if (isPrime[i]) primes.add(i);
}
```

3. 두 포인터 `l`, `r`과 현재 구간 합 `sum`을 사용해 소수 리스트의 연속 부분합을 탐색합니다. 오른쪽 포인터 `r`를 한 칸씩 늘리며 `sum`에 더하고, `sum >= N`인 동안 왼쪽 포인터 `l`을 옮기면서 구간을 줄입니다.  
   이때 `sum == N`이면 경우의 수 `cnt`를 1 증가시킵니다.
```java
int l = 0, r = 0, sum = 0, cnt = 0;
while (l <= r && r < size) {
    sum += primes.get(r);
    while (sum >= N) {
        if (sum == N) cnt++;
        sum -= primes.get(l++);
    }
    r++;
}
```

4. 모든 구간을 확인한 뒤 `cnt`를 출력하면, 소수의 연속합으로 N을 만들 수 있는 경우의 수가 됩니다.

## :black_nib: **Review**

- 에라토스테네스의 체와 투 포인터를 함께 연습하기 좋은 문제였다.
- 소수 리스트만 따로 만들어 두고 그 위에서만 슬라이딩 윈도우를 돌리니 구현이 깔끔해졌다.

## 📡 Link

https://www.acmicpc.net/problem/1644
