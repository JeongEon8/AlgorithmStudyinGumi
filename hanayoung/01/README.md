# [백준 - 실버 5] 25757. 임스와 함께하는 미니게임

## ⏰  **time**
10분

## :pushpin: **Algorithm**
해시

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 타입에 따른 플레이어 수 저장
```java
int playerNum = (type == 'Y') ? 2 : (type == 'F') ? 3 : 4;
```
2. 중복되지 않는 플레이어 저장
```java
hashSet.add(st.nextToken());
```
3. 임스를 뺀 인원을 나눠서 게임 진행 수 확인
```java
  int answer = hashSet.size()/(playerNum-1);
```

## :black_nib: **Review**
- 해시로 간단히 푸는 문제

## 📡 Link
https://www.acmicpc.net/problem/25757
