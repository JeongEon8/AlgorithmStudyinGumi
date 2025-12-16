# [백준 - S4] 20004. 베스킨라빈스 31

## ⏰ **time**

10분

## :pushpin: **Algorithm**

- 수학
- 게임 이론


## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
후턴 플레이어는 선턴 플레이어가 외친 수에 따라 n+1만 확정적으로 외칠 수 있다.  
30을 외치면 승리할 수 있으므로 n+1이 30의 약수인경우 후턴 플레이어가 항상 승리할 수 있다.
```java
for (int i = 1; i <= a; i++) {
    if (30 % (i + 1) == 0) {
        sb.append(i).append('\n');
    }
}
```  


## :black_nib: **Review**  

## 📡**Link**
https://www.acmicpc.net/problem/20004