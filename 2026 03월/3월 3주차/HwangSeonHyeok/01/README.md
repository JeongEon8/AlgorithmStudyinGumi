# [백준 - S4] 12981. 공 포장하기


## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 수학
- 그리디 알고리즘
- 많은 조건 분기

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
최소 횟수를위해 공이 3개씩 넣을 수 있는경우부터 우선한다.  
3개 모두 다르게 들어가는경우는 가장 적은 공의 갯수와 같고, 남은 공들은 같은색 3개씩 넣을 수 있다.  
2개 이하씩 남은 공들은 어떤 조합으로도 넣을 수 있으므로 홀수인경우 하나가 들어가는 경우를 포함해서 (남은공의 총합+1)/2개의 박스가 필요하다.
```java
Arrays.sort(balls);
int ans = 0;
ans += balls[0];
for (int i = 1; i <= 2; i++) {
    balls[i] -= balls[0];
    ans += balls[i] / 3;
    balls[i] %= 3;
}
ans += (balls[1] + balls[2] + 1) / 2;
```

## :black_nib: **Review** 

## 📡**Link**
https://www.acmicpc.net/problem/12981