# [백준 - s3] 18310. 안테나
## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학
- 그리디 알고리즘
- 정렬

## :round_pushpin: **Logic**

직선위의 점들에서 거리차가 최단인 점은 홀수개이면 가운데 점, 짝수개면 가운데 두 점사이의 지점이다. 여러 값인경우 가장 작은값이므로 가운데 두 점중 더 작은 쪽이 가장 작은 점이다.

```java
   if (n % 2 == 0) {
        System.out.println(houses[n / 2 - 1]);
    } else {
        System.out.println(houses[n / 2]);
    }

```

## :black_nib: **Review**

파스타랑 무슨 상관이..

## 📡**Link**

https://www.acmicpc.net/problem/18310

