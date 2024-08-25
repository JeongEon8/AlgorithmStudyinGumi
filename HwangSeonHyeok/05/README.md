# [백준 - s5] 2890. 카약

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현
- 문자열
- 정렬

## :round_pushpin: **Logic**

카약 정보엔 카약의 번호와 카약의 뒷부분의 위치index를 저장한다.
이걸 시작위치를 기준으로 정렬하면 등수를 알 수 있다.

```java
   static class Kayak implements Comparable<Kayak> {
        int num, startC;

        public Kayak(int num, int startC) {
            this.num = num;
            this.startC = startC;

        }

        @Override
        public int compareTo(Kayak o) {

            return o.startC - this.startC;
        }

    }

```

## :black_nib: **Review**

랜덤 문제에서 2891번 카약과 강풍이 나왔으나 시리즈 문제길래 먼저 풀어보았다.

## 📡**Link**

- https://www.acmicpc.net/problem/2890
