# [백준 - s2] 30022. 행사 준비

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬

## :round_pushpin: **Logic**

a와 b의 차이만큼 기준으로 오름차순으로 정렬하고 A-1번 index까지 a값을 더하고 나머지 index는 b만큼 더한다.

```java
   static class Item implements Comparable<Item> {
        int a, b, diff;

        public Item(int a, int b) {
            super();
            this.a = a;
            this.b = b;
            this.diff = a - b;
        }

        @Override
        public int compareTo(Item o) {
            return (int) (this.diff - o.diff);
        }
    }

```

## 📡**Link**

https://www.acmicpc.net/problem/30022
