# [백준 - G5] 28017. 게임을 클리어하자

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
이전 회차에서 썼던 무기를 쓸 수 없기 때문에 이전회차에서 가장 빨랐던 무기의 시간, index와 두번째로 빠른 무기의 클리어 시간을 기록해두고 다음 회차에서 가장빠른 index의 무기는 두번째로 빠른 클리어 타임을 기준으로, 나머지는 가장 빠른 클리어 타임기준으로 시간을 계산해나가면된다.
```java
for (int i = 1; i < n; i++) {
    int tmpFirstIdx = 0;
    int tmpFirstTime = secondTime + 10001;
    int tmpSecondTime = secondTime + 10001;
    for (int j = 0; j < m; j++) {
        int currentTime = (j != firstIdx) ? firstTime + clearTime[i][j] : secondTime + clearTime[i][j];
        if (currentTime < tmpFirstTime) {
            tmpSecondTime = tmpFirstTime;
            tmpFirstTime = currentTime;
            tmpFirstIdx = j;
        } else if (currentTime < tmpSecondTime && currentTime >= tmpFirstTime) {
            tmpSecondTime = currentTime;
        }
    }
    firstIdx = tmpFirstIdx;
    firstTime = tmpFirstTime;
    secondTime = tmpSecondTime;

}
```  
## :black_nib: **Review**


## 📡**Link**
https://www.acmicpc.net/problem/28017
