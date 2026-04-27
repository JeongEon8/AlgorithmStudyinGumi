# [백준 - S5] 1436. 영화감독 숌

## ⏰  **time**
20분

## :pushpin: **Algorithm**
브루트포스

## ⏲️**Time Complexity**
$O(Nlog N)$

## :round_pushpin: **Logic**
1. cnt는 666 포함 숫자 개수, idx는 1씩 늘려가며 확인할 숫자, answer는 N번째 666포함 숫자
```java
        int cnt = 0;
        int idx = 666;
        int answer = 0;
```
2. 666포함 숫자 개수가 N이 될 때까지 반복
3. idx를 string화해서 666을 포함하는지 찾기, 포함하면 cnt 증가
4. cnt가 N이면 answer를 idx로 업데이트
5. 한 턴이 끝나면 idx 증가
```java
        while(cnt < N) {
            if((idx+"").contains("666")) {
                cnt++;
            }
            if(cnt == N) answer = idx;
            idx++;
        }
```

## :black_nib: **Review**
- 논리를 짜야하는 줄 알았더니 냅다 다 돌기 문제..!

## 📡 Link
https://www.acmicpc.net/problem/1436
