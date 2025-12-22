# [백준 - 실버 4] 10825.국영수

## ⏰  **time**
20분 

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(N log N)$

## :round_pushpin: **Logic**
1. 정렬 기준 만들기
 1. 국어 점수가 감소하는 순서로
 2.  국어 점수가 같으면 영어 점수가 증가하는 순서로
 3.  국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로
 4.  모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.)
```java
    @Override
        public int compareTo(Main.Score o) {
            if(this.korean > o.korean) return -1;
            else if(this.korean == o.korean && this.english < o.english) return -1;
            else if(this.korean == o.korean && this.english == o.english && this.math > o.math) return -1;
            else if(this.korean == o.korean && this.english == o.english && this.math == o.math && this.name.compareTo(o.name) < 0) return -1;
            else return 1;
        }
```
2. 정렬 기준을 만든 class를 타입으로 하는 우선순위큐에 데이터 담기
3. 하나씩 꺼내서 프린트하기 끝 !

## :black_nib: **Review**
- 우선순위큐 최고! 간만에 comparable 쓰니까 헷갈린당

## 📡 Link
https://www.acmicpc.net/problem/10825
