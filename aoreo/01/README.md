# [백준 - 실버 4] 11399. ATM
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
우선순위큐

## ⏲️**Time Complexity**
$O(nlog(n))$

## :round_pushpin: **Logic**
1. 걸리는 시간이 적은 순으로 꺼낼 수 있도록 우선순위큐에 담기
2. 모든 사람이 인출하는 데에 필요한 시간이므로 제일 첫 번째로 인출한 사람 시간만큼 N명의 시간이 사용된다는 점에서 차용하여 걸린 시간 * 현재 사람 수만큼을 더함. N은 1씩 줄여감
```java
  while(pQueue.size() != 0) {
    int time = pQueue.poll();
    answer += time * N;
    N -= 1;
        }
```

## :black_nib: **Review**
- 우선순위큐 만만세

## 📡 Link
https://www.acmicpc.net/problem/11399
