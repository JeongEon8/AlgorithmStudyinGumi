# [백준 - S4] 1158. 요세푸스 문제

## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현, 자료구조

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. 1부터 N까지 숫자 삽입
```java
        List<Integer> list = new ArrayList<>();

        for(int i = 1 ; i <= N; i++) {
            list.add(i);
        }
```
2. idx 초기값 0으로 설정
3. list의 크기가 1보다 클 때까지 반복
4. idx에서 K-1을 더한 값(K번째 이후의 값)에 list.size()를 나눈 나머지를 idx로 업데이트
5. 해당 인덱스의 값을 sb에 붙이고 list에서 값 제거
6. list의 크기가 1이 되면 가장 앞의 값을 sb에 붙이기
```java
        int idx = 0;

        while(list.size() > 1) {
            idx = (idx + K-1) % list.size();
            sb.append(list.get(idx)).append(", ");
            list.remove(idx);
        }
        sb.append(list.get(0)).append(">");
```
7. sb 출력하기


## :black_nib: **Review**
- 로직 생각해냈는데 K-1로 안하고 냅다 예시에 나온 2로 해서 틀리는 엄청난 바보짓해버림.. ! 문제 제대로 읽자!

## 📡 Link
https://www.acmicpc.net/problem/1158
