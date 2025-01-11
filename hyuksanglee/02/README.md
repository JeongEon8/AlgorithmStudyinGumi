# [프로그래머스-L2] 뒤에 있는 큰 수 찾기

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 스택
## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
1. 스택에 저장된 마지막 인덱스가 가리키는 값이 현재 값보다 작으면, 해당 인덱스를 스택에서 제거하고 answer 배열에 현재 값을 저장합니다.

2. 1번을 스택에 마지막 값보다 큰 값이 나올떄까지 반복

3. 현재 인덱스를 스택에 추가

4. 스택에 남아 있는 인덱스 -1로 처리


```java
for (int i = 0; i < numbers.length; i++) {
            // 스택의 최상단 값과 비교하여 조건을 만족하면 결과 저장
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                int index = stack.pop();
                answer[index] = numbers[i];
            }
            // 현재 인덱스를 스택에 추가
            stack.push(i);
        }

        // 스택에 남아 있는 인덱스는 오른쪽에 큰 값이 없음
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
```

## :black_nib: **Review**
스택 , so easy

## 📡**Link**

https://school.programmers.co.kr/learn/courses/30/lessons/154539
