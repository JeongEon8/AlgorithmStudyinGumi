# [백준 - S5] 12760. 최후의 승자는 누구?

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현
- 정렬
- 시뮬레이션

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
각 플레이어들의 카드를 정렬하여 낼 순서를 정하고 각 플레이어들의 점수를 구한다.  
최고 점수를 구하고 최고 점수인 사람들을 찾는다.
```java
for (int i = 0; i < n; i++) {
    Arrays.sort(info[i]);
}
int[] score = new int[n];
for (int i = 0; i < m; i++) {
    int max = 0;
    for (int j = 0; j < n; j++) {
        max = Math.max(max, info[j][i]);
    }
    for (int j = 0; j < n; j++) {
        if (info[j][i] == max) {
            score[j]++;
        }
    }
}
int highScore = 0;
for (int i = 0; i < n; i++) {
    highScore = Math.max(highScore, score[i]);
}
StringBuilder sb = new StringBuilder();
for (int i = 0; i < n; i++) {
    if (score[i] == highScore) {
        sb.append(i + 1).append(" ");
    }
}
```
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/12760