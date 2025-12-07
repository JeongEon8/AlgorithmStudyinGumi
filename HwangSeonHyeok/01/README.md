# [백준 - S3] 2852. NBA 농구

## ⏰ **time**

25분

## :pushpin: **Algorithm**
- 구현
- 문자열

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
기록을 분단위로 저장하고 이전 골까지의 시간 차를 이기고 있는팀의 이긴 시간에 더한다. 시간을 계산하고 점수를 올린다.
```java
int scoreOne = isTeamOne[0] ? 1 : 0;
int scoreTwo = isTeamOne[0] ? 0 : 1;
int winningTimeOne = 0;
int winningTimeTwo = 0;
for (int i = 1; i < n; i++) {
    if (scoreOne > scoreTwo) {
        winningTimeOne += goalTimes[i] - goalTimes[i - 1];
    } else if (scoreTwo > scoreOne) {
        winningTimeTwo += goalTimes[i] - goalTimes[i - 1];
    }
    if (isTeamOne[i]) {
        scoreOne++;
    } else {
        scoreTwo++;
    }
}
```

## :black_nib: **Review** 


## 📡**Link**
https://www.acmicpc.net/problem/2852