# [프로그래머스 - LV.2] 의상
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
해시

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 옷을 종류 별로 넣고 가능한 조합 구하기
```java
    static class Tangerine implements Comparable<Tangerine>{
        int size;
        int cnt;

        public Tangerine(int size, int cnt) {
            this.size = size;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Tangerine o) {
          if(this.cnt < o.cnt) return 1;
          else return -1;
        }
    }
```

## :black_nib: **Review**
- 

## 📡 Link
https://school.programmers.co.kr/learn/courses/30/lessons/42578?language=java
