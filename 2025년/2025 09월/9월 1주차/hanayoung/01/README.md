# [백준 - S4] 1026. 보물

## ⏰  **time**
15분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 정수 배열 담을 두 개의 변수 선언, Collections.reverseOrder()를 이용해 정렬을 할 예정이므로 하나는 Integer로 선언
```java
        int[] arrA = new int[N];
        Integer[] arrB = new Integer[N];
```
2. 하나는 역으로, 하나는 정으로 정렬
```java
        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());
```
3. 가장 큰 거는 가장 작은 것과 곱하는 것이 숫자를 작게 하는 것이라는 생각에, 정렬해서 곱하고 더하기
```java
        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += arrA[i]*arrB[i];
        }
```


## :black_nib: **Review**
- 단순히 생각해도 풀렸던 문제,, 이때까진 그리디 나쁘지 않을지도.. 였던 ,,, 실버라서 가능했던 이야기

## 📡**Link**
- https://www.acmicpc.net/problem/1026
