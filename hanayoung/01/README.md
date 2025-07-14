# [백준 - S5] 7568. 덩치

## ⏰  **time**
4시간

## :pushpin: **Algorithm**
브루트포스 알고리즘

## ⏲️**Time Complexity**
$O(N^2)$

## :round_pushpin: **Logic**
1. People 클래스 만들어서 키 몸무게 관리
```java
    static class People {
        int height;
        int weight;

        People(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }
```
2. 다 돌면서 i번째 덩치가 더 작으면 order을 1 증가
```java
        for (int i = 0; i < N; i++) {
            int order = 1;
            for (int j = 0; j < N; j++) {
                if (people[i].height < people[j].height && people[i].weight < people[j].weight) {
                    order += 1;
                } 
            }
            ranks[i] = order;
        }
```

## :black_nib: **Review**
- 너무 복잡하게 생겨서 완전 오래 걸렸고 지난번에 풀다가 포기한 문젠데 알고보니 그냥 냅다 다 돌기 문제였다...

## 📡 Link
https://www.acmicpc.net/problem/7568
