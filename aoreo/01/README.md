# [백준 - S5] 10867. 중복 빼고 정렬하기

## ⏰ **time**
5분

## :pushpin: **Algorithm**
- 정렬, 우선순위큐

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. HashSet에 받은 모든 값을 넣기
```java
for (int i = 0; i < N; i++) {
            set.add(Integer.valueOf(st.nextToken()));
        }
```
2. PriorityQueue에 HashSet의 값 넣기
```java
for (Integer e : set) {
  pQueue.add(e);
}
```
3. 하나씩 뽑아서 출력하기 끝 ~

## :black_nib: **Review**  
실버5 따봉 우선순위큐 따봉

## 📡**Link**
https://www.acmicpc.net/problem/10867
