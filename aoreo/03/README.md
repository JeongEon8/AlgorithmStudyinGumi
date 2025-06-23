# [백준 - S5] 11650.좌료 정렬하기

## ⏰  **time**
15분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(nlogn)$

## :round_pushpin: **Logic**
1. Coord라는 class 생성하여 x값 y값 담기
2. Comparable implements하여 정렬 기준 정하기, x가 작을 수록, 같은 경우엔 y값이 작을수록으로 정렬
```java
        @Override
        public int compareTo(Coord o) {
            if(this.x < o.x) return -1;
            else if(this.x == o.x && this.y < o.y) return -1;
            else return 1;
        }
```
3. 우선순위큐에 모든 좌표를 담고 하나씩 출력

## :black_nib: **Review**
- 우선순위큐 조아
  
## 📡 Link
https://www.acmicpc.net/problem/11650
