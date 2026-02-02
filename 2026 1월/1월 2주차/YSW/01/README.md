# [백준 - G5] 1206. 사람의 수 (Hard)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 수학
- 브루트포스 알고리즘

## ⏲️**Time Complexity**

$O(P*N*log(10P))$  >> P는 사람 수의 최대 범위

## :round_pushpin: **Logic**

문제에서 요구하는 정답은 가능한 최소 인원수이므로, 1명부터 1000명까지 순차적으로 시도합니다.
특정 인원수(i)에 대하여, 입력으로 들어온 모든 평균값(target, 소수점이 제거된 정수 형태)이 실제로 만들어질 수 있는지 하나씩 검사합니다.
각 평균값에 대해 (점수 총합 * 1000) / 인원수(i)를 계산했을 때 목표값과 일치하는 정수 총합이 존재하는지 이진 탐색으로 빠르게 확인합니다.
처음으로 모든 평균값을 만족하는 (i)를 찾으면, 그것이 최소 인원수이므로 즉시 출력하고 프로그램을 종료합니다.

```java
		for (int i = 1; i <= 1000; i++) {
            boolean allPossible = true;

            for (int target : surveys) {
                boolean match = false;
                
                int low = 0;
                int high = i * 10;
                
                while (low <= high) {
                    int mid = (low + high) / 2;
                    int val = (mid * 1000) / i;
                    
                    if (val == target) {
                        match = true;
                        break;
                    } else if (val < target) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                if (!match) {
                    allPossible = false;
                    break;
                }
            }

            if (allPossible) {
                System.out.println(i);
                return;
            }
        }
```

## :black_nib: **Review**

너무너무너무 어려웠다.

## 📡**Link**

https://www.acmicpc.net/problem/1206
