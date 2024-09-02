# [백준 - s4] 25214. 크림 파스타

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 그리디 알고리즘

## :round_pushpin: **Logic**

지금까지의 최솟값을 기록하고 현제 INDEX와 최솟값의 차이가 가장 큰 경우를 기록한다.

```java
   for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(st.nextToken());
            if (min > current) {
                min = current;
            }
            if (diff < current - min) {
                diff = current - min;
            }
            sb.append(diff + " ");
        }

```

## :black_nib: **Review**

파스타랑 무슨 상관이..

## 📡**Link**

https://www.acmicpc.net/problem/25214


