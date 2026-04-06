# [백준 - 골드 2] 16565. N포커

## ⏰**time**

28분

## :pushpin: **Algorithm**

- 조합 (nCr)
- 포함-배제 원리
- 모듈러 연산

## ⏲️**Time Complexity**

$O(52^2)$  
(파스칼 삼각형으로 조합 전처리)

## :round_pushpin: **Logic**

1. `comb[n][r] = nCr mod 10007`을 파스칼 삼각형 방식으로 미리 계산합니다.

```java
int[][] comb = new int[53][53];
for (int n = 0; n <= 52; n++) {
    comb[n][0] = 1;
    comb[n][n] = 1;
    for (int r = 1; r < n; r++) {
        comb[n][r] = (comb[n - 1][r - 1] + comb[n - 1][r]) % MOD;
    }
}
```

2. 포카드(같은 숫자 4장)가 최소 1개 이상 포함되는 경우의 수를 포함-배제로 계산합니다.  
   `i`개의 숫자를 포카드로 고른다고 하면:
   - 포카드 숫자 선택: `C(13, i)`
   - 이미 고정된 `4i`장을 제외하고 나머지 카드에서 `N - 4i`장 선택: `C(52 - 4i, N - 4i)`

```java
int cnt = (comb[13][i] * comb[52 - 4 * i][N - 4 * i]) % MOD;
```

3. 포함-배제 부호를 적용합니다.
   - `i`가 홀수면 더하기
   - `i`가 짝수면 빼기  
     (MOD 연산에서 음수 방지를 위해 `+ MOD`)

```java
if (i % 2 == 1)
    ans = (ans + cnt) % MOD;
else
    ans = (ans - cnt + MOD) % MOD;
```

4. `i = 1`부터 `N/4`까지 반복한 뒤 최종 `ans`를 출력합니다.

```java
System.out.println(ans);
```

## :black_nib: **Review**

- 오랜만에 확통을 다시 공부하게 만든 문제..

## 📡 Link

https://www.acmicpc.net/problem/16565
