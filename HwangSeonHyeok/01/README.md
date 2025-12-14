# [백준 - S5] 5839. Cow Race

## ⏰ **time**

20분

## :pushpin: **Algorithm**
- 구현
- 시뮬레이션

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
각 소들이 속도가 바뀔때마다 누가 더빠른지 체크를 한다.  
각속도마다 남은 속도 시간이 더 짧은걸 기준으로 진행하고 현제 이동거리와 선두, 시간, 속도를 갱신한다. 
```java
while (aIdx < n && bIdx < m) {
    int currentTime = Math.min(aRemain, bRemain);
    distA += infoA[aIdx][0] * currentTime;
    distB += infoB[bIdx][0] * currentTime;

    aRemain -= currentTime;
    bRemain -= currentTime;

    if (distA > distB) {
        if (faster == 2) {
            ans++;
            faster = 1;
        } else if (faster == 0) {
            faster = 1;
        }
    } else if (distB > distA) {
        if (faster == 1) {
            ans++;
            faster = 2;
        } else if (faster == 0) {
            faster = 2;
        }
    }

    if (aRemain == 0) {
        aIdx++;
        if (aIdx < n) {
            aRemain = infoA[aIdx][1];
        }
    }

    if (bRemain == 0) {
        bIdx++;
        if (bIdx < m) {
            bRemain = infoB[bIdx][1];
        }
    }

}
```

## :black_nib: **Review** 


## 📡**Link**
https://www.acmicpc.net/problem/5839