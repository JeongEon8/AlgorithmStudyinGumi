# [프로그래머스 - lv2] 뒤에 있는 큰 수 찾기
 
## ⏰  **time**
20분

## :pushpin: **Algorithm**
- 스택

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 초기 answer을 -1로 초기화 한다.
- 스택이 비어있으면 넣고, 스택 안에 원소가 있으면 비교한다.
- 마지막 원소가 numbers의 원소보다 작으면 해당 원소 번째 있는 수에 넣는다.
```
    lng = len(numbers)
    answer = [-1 for _ in range(lng)]
    stack = []
    
    for i in range(lng):
        while stack and numbers[stack[-1]] < numbers[i]:
            answer[stack.pop()] = numbers[i]
        stack.append(i)
```


## :black_nib: **Review**

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/154539
