# [백준 - S4] 1269. 대칭 차집

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 리스트

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- 각각에 리스트에 a와 b를 입력받은 값을넣고
- a에서 b값이 없으면 결과값 증가
- b에서 a값이 없으면 결과값 증가
- 결과값 출력

```java
for (int num : B) {
            if (!A.contains(num)) {
                count++;
            }
        }
```

## :black_nib: **Review**


## 📡**Link**

https://www.acmicpc.net/problem/1269
