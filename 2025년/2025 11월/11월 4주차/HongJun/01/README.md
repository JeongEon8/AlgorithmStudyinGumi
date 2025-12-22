# [프로그래머스 - lv2] 단어 변환
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
- bfs

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- Node라는 data class를 만들고 (단어, 단계) 인자를 넣는다.
- bfs를 돌리기 위한 deque에 begin 단어와 0단계를 넣는다.
- canChange라는 단어를 바꿀 수 있는지 확인하는 함수를 만든다.
  - 두 단어가 한 글자 차이인지 체크하는 함수이다.
- 방문한 적이 없고 바꿀 수 있다면 deque에 넣고 방문처리를 해준다.
- 타겟 단어와 같아지면 return
  
```
    var visited = BooleanArray(words.size)
    var q = ArrayDeque<Node>()
    q.add(Node(begin, 0))
    
    while (q.isNotEmpty()) {
        val current = q.removeFirst()
        
        if (current.word == target) {
            return current.step
        }
        
        for (i in words.indices) {
            if (!visited[i] && canChange(current.word, words[i])) {
                q.add(Node(words[i], current.step + 1))
                visited[i] = true
            }
        }
    }
    
    
    fun canChange(begin: String, end: String): Boolean {
        var temp = 0
        for (i in begin.indices) {
            if (begin[i] != end[i]) temp++
        }

        if (temp == 1) return true
        else return false
    }
```

## :black_nib: **Review**

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/43163
