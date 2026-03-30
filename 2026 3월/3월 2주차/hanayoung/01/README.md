# [백준 - S4] 17219. 비밀번호 찾기

## ⏰  **time**
10분

## :pushpin: **Algorithm**
자료구조, 집합과 맵

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 사이트, 비밀번호 쌍을 저장할 해시맵 생성
```java
Map<String, String> pwdMap = new HashMap<>();
```
2. 출력할 내용 담을 StringBuilder 선언
```java
StringBuilder sb = new StringBuilder();
```
3. 사이트별 비밀번호 해시맵에 저장
```java
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            pwdMap.put(st.nextToken(), st.nextToken());
        }
```
4. 비밀번호를 찾을 사이트를 해시맵에서 꺼내서 sb에 붙이기
```java
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            sb.append(pwdMap.get(st.nextToken())).append("\n");
        }
```
5. sb 출력
```java
System.out.println(sb);
```


## :black_nib: **Review**
- 해시맵 최고!

## 📡 Link
https://www.acmicpc.net/problem/17219
