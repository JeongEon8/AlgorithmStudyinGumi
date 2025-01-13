# [프로그래머스 - LV.2] 귤 고르기
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
완전탐색

## ⏲️**Time Complexity**
$O(N^3)$

## :round_pushpin: **Logic**
1. 1 <= tangerine의 원소 <= 10,000,000이므로, 10000001 크기의 배열 생성하여, 해당 배열은 인덱스를 사이즈로 갖는 귤의 개수를 담는 배열
2. 크기가 서로 다른 종류의 수의 최솟값이 되도록 귤을 담기 위해서 Comparable implements하기
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
3. tmp를 돌며, 크기가 0이 아닌 경우, 우선순위큐에 추가
4. 귤을 담은 수인 boxCnt가 담아야 하는 수인 k가 될 때까지 큐의 값을 꺼내기를 반복
```java
        while(boxCnt < k) {
            Tangerine tan = pQueue.poll();
            boxCnt += tan.cnt;
            answer += 1;
        }
   ```

## :black_nib: **Review**
- 우선순위큐 조

## 📡 Link
https://school.programmers.co.kr/learn/courses/30/lessons/138476
