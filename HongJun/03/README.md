
# [프로그래머스 - Lv.2] 타겟 넘버

## ⏰  **time**
30분

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
- DFS 백트래킹 문제
- 모든 숫자를 다 사용하면 종료하도록 조건을 건다
- 합과 타겟 넘버가 같으면 1을 리턴한다
- 더하는 경우, 빼는 경우를 재귀로 반복한다

```kotlin
    fun dfs(index: Int, curSum: Int): Int {
        // 모든 숫자를 다 사용하면 종료
        if (index == numbers.size) {
            return if (curSum == target) 1 else 0
        }
        
        // 더하는 경우, 빼는 경우
        var plus = dfs(index + 1, curSum + numbers[index])
        var minus = dfs(index + 1, curSum - numbers[index])
        
        return plus+minus
    }
```

## :black_nib: **Review**


## 📡**Link**

- https://school.programmers.co.kr/learn/courses/30/lessons/43165
