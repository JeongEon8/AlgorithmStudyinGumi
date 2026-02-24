# [백준 - 골드 4] 9252. LCS 2

## ⏰**time**

20분

## :pushpin: **Algorithm**

- DP (Longest Common Subsequence)
- LCS 역추적 (Backtracking)

## ⏲️**Time Complexity**

$O(N \\times M)$  
(\(N\): 첫 번째 문자열 길이, \(M\): 두 번째 문자열 길이)

## :round_pushpin: **Logic**

1. 두 문자열을 문자 배열로 받아 길이 \(n, m\)을 구하고, `dp[i][j]`를 **앞에서부터 i글자, j글자까지의 LCS 길이**로 정의합니다.

```java
char[] a = br.readLine().toCharArray();
char[] b = br.readLine().toCharArray();
int n = a.length, m = b.length;
int[][] dp = new int[n + 1][m + 1];
```

2. LCS 점화식에 따라 DP 테이블을 채웁니다.
   - 문자가 같으면: 대각선 값 + 1
   - 다르면: 위쪽/왼쪽 중 더 큰 값

```java
for (int i = 1; i <= n; i++) {
    for (int j = 1; j <= m; j++) {
        if (a[i - 1] == b[j - 1]) {
            dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
            dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
    }
}
System.out.println(dp[n][m]); // LCS 길이
```

3. `dp[n][m]`에서 시작해 역추적을 하며 실제 LCS 문자열을 구성합니다.
   - 두 문자가 같다면 해당 문자를 결과에 추가하고 대각선으로 이동
   - 다르면 `dp[i-1][j]`와 `dp[i][j-1]` 중 더 큰 쪽으로 이동

```java
StringBuilder sb = new StringBuilder();
int i = n, j = m;
while (i > 0 && j > 0) {
    if (a[i - 1] == b[j - 1]) {
        sb.append(a[i - 1]);
        i--; j--;
    } else {
        if (dp[i - 1][j] >= dp[i][j - 1]) i--;
        else j--;
    }
}
System.out.println(sb.reverse());
```

## :black_nib: **Review**

- LCS 알고리즘을 까먹어서 다시 공부했습니다..

## 📡 Link

https://www.acmicpc.net/problem/9252
