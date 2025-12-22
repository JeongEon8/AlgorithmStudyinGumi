# [백준 - 실버 4] 1764. 듣보잡
 
## ⏰  **time**
25분

## :pushpin: **Algorithm**
해시

## ⏲️**Time Complexity**
$O(n+m)$

## :round_pushpin: **Logic**
1. 듣도 못한 사람의 이름을 key로 hashmap에 저장
2. 보도 못한 사람의 이름을 key로 hashmap에 조회하여, 있을 경우 듣도보도못한 우선순위큐에 저장
```java
  st = new StringTokenizer(bf.readLine());
  String next = st.nextToken();
  if(neverHeard.containsKey(next)) neverHeardAndSeen.add(next);
```
3. 우선순위큐 길이 출력 후 하나씩 꺼내기
   
## :black_nib: **Review**
- 냅다 우선순위큐와 arraylist만 썼더니 시간초과로 두 번 얻어맞고 해시로 ...

## 📡 Link
https://www.acmicpc.net/problem/1764
