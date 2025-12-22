# [백준 - S5] 14425. 문자열 집합

## ⏰  **time**
15분

## :pushpin: **Algorithm**
해시

## ⏲️**Time Complexity**
$O(n+m)$

## :round_pushpin: **Logic**
1. HashMap에 등장한 스트링을 키로 갖는 값 삽입
```java
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            hashMap.put(st.nextToken(), true);
        }
```
2. hashMap에 존재하는 key면 answer에 1 더하기, 추후에 answer를 출력
```java
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            String target = st.nextToken();

            if(hashMap.containsKey(target)) answer += 1;
        }
```

## :black_nib: **Review**
- 간단한 해시 문제 처음에 꼬아서 생각했는데 쉬운 문제였다

## 📡 Link
https://www.acmicpc.net/problem/14425
