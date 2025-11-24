
# [프로그래머스 - Lv.2] 네트워크

## ⏰  **time**
30분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
- 코틀린의 ArrayDeque로 BFS를 실행한다.
- 미로 찾기가 아닌 노드 연결이기 때문에 visited 배열을 노드의 개수만큼 만들고 방문처리를 한다.

```kotlin
var visited = BooleanArray(n)
        
        for (start in 0 until n) {
            if (!visited[start]) {
                answer++
                
                val q = ArrayDeque<Int>()
                q.add(start)
                visited[start] = true
                
                while(q.isNotEmpty()) {
                    var cur = q.removeFirst()
                    
                    for(next in 0 until n) {
                        if (computers[cur][next] == 1 && !visited[next]) {
                            visited[next] = true
                            q.add(next)
                        }
                    }
                }
            }
        }
```

## :black_nib: **Review**


## 📡**Link**

- https://school.programmers.co.kr/learn/courses/30/lessons/43162
