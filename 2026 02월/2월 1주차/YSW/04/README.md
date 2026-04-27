# [백준 - S4] 24499. blobyum (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 누적 합
- 슬라이딩 윈도우

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

원형으로 놓인 n개의 파이에서 연속된 k개를 선택했을 때 얻을 수 있는 합의 최댓값을 구하는 문제이다.
먼저 처음 k개의 파이 합을 계산하여 currentSum에 저장한다. 이 값이 원형 배열에서의 초기 구간 합이 된다.
이후 슬라이딩 윈도우 기법을 사용해 구간을 한 칸씩 이동시킨다. 구간을 이동할 때는 새로 포함되는 파이 pies[(i + k) % n]를 더하고, 기존에 포함되어 있던 파이 pies[i]를 빼서 구간 합을 갱신한다.
이때 인덱스에 % n을 사용하여 원형 구조를 처리한다. 각 구간에서의 합을 max와 비교하여 최댓값을 계속 갱신한다.
모든 가능한 구간을 확인한 뒤 얻은 max가 정답이다.

```java
        int currentSum = 0;
        for (int i = 0; i < k; i++) {
            currentSum += pies[i];
        }

        int max = currentSum;

        for (int i = 0; i < n; i++) {
            currentSum = currentSum + pies[(i + k) % n] - pies[i];
            max = Math.max(max, currentSum);
        }
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/24499
