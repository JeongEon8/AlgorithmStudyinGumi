# [백준 - S1] 26085. 효구와 호규 (Easy)

## ⏰ **time**

20분

## :pushpin: **Algorithm**
- 애드 혹
- 홀짝성
- 비둘기집 원리

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
숫자 카드 0과 1이 각각 짝수개인경우 서로 인접한 카드 1세트라도 존재하면 모든 카드를 지울 수 있다. 
```java
if (oneCard % 2 != 0 || zeroCard % 2 != 0) {
    isAble = false;
}
if (isAble) {
    boolean canRemove = false;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (j + 1 < m && cards[i][j] == cards[i][j + 1]) {
                canRemove = true;
                break;
            }
            if (i + 1 < n && cards[i][j] == cards[i + 1][j]) {
                canRemove = true;
                break;
            }
        }
        if (canRemove)
            break;
    }
    if (!canRemove)
        isAble = false;
}

if (isAble) {
    System.out.println(1);
} else {
    System.out.println(-1);
}
```

## :black_nib: **Review**  
규칙을 찾는 문제
## 📡**Link**
https://www.acmicpc.net/problem/26085
