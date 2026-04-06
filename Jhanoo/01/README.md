# [백준 - 골드 2] 15824. 너 봄에는 캡사이신이 맛있단다

## ⏰**time**

56분

## :pushpin: **Algorithm**

- 정렬
- 조합 기여도 계산
- 모듈러 연산

## ⏲️**Time Complexity**

$O(N \log N)$  
(정렬 이후 1회 순회)

## :round_pushpin: **Logic**

1. 스코빌 지수를 오름차순 정렬합니다.  
   부분집합에서 각 원소가 최댓값/최솟값으로 선택되는 횟수를 세기 쉽게 만들기 위함입니다.

```java
Arrays.sort(scoville);
```

2. `2^k (mod MOD)` 값을 미리 `pow2[]`에 저장합니다.

```java
long[] pow2 = new long[N];
pow2[0] = 1;
for (int i = 1; i < N; i++) {
    pow2[i] = (pow2[i - 1] * 2) % MOD;
}
```

3. 정렬된 배열에서 `scoville[i]`가
   - **최댓값**으로 등장하는 횟수: `2^i`
   - **최솟값**으로 등장하는 횟수: `2^(N-1-i)`
     이므로, 전체 기여도는  
     `scoville[i] * (2^i - 2^(N-1-i))` 입니다.

```java
for (int i = 0; i < N; i++) {
    long maxCount = pow2[i];
    long minCount = pow2[N - 1 - i];
    long contribution = (maxCount - minCount + MOD) % MOD;
    sum = (sum + scoville[i] * contribution) % MOD;
}
```

4. 모든 원소의 기여도를 더한 값을 `MOD = 1,000,000,007`로 나눈 나머지로 출력합니다.

```java
System.out.println(sum);
```

## :black_nib: **Review**

- 정렬 이후 두 수를 찾고 그 사이의 부분집합의 개수로 곱하여 구하려다가 N^2으로 시간초과가 나서 수식을 정리하니 순회 한번으로 문제가 풀렸다.
- Σ (a[r] - a[l]) _ 2^(r-l-1) (l < r)
  → Σ a[i] _ (2^i - 2^(N-1-i))

## 📡 Link

https://www.acmicpc.net/problem/15824
