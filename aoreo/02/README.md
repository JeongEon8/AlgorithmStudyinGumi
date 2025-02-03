# [백준 - 실버 5] 10814. 나이순 정렬 
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
우선순위큐

## ⏲️**Time Complexity**
$O(N logN)$

## :round_pushpin: **Logic**
1. 회원의 인덱스, 나이, 이름을 가지는 클래스 생성, Comparable을 implements하여 나이로 비교하고, 나이가 같을 경우 먼저 등록한 회원 순으로 나올 수 있도록 함 
```java
 static class Member implements Comparable<Member>{
        int idx;
        int age;
        String name;

        public Member(int idx, int age, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Main.Member o) {
            if(this.age < o.age) return -1;
            else if(this.age == o.age) {
                if(this.idx < o.idx) return -1;
                else return 1;
            }
            else return 1;
        }
    }
```   
2. 냅다 넣고 냅다 꺼내기

## :black_nib: **Review**
- 우선순위큐 최고 ! 해도해도 헷갈리는 compareTo 함수,,, 어떻게 비교하드라

## 📡 Link
https://www.acmicpc.net/problem/10814
