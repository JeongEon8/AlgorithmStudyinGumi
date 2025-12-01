# [프로그래머스 - lv2] 조이스틱
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
- 그리디

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
- 다음 알파벳과 이전 알파벳으로 돌아가는 경우 2가지를 비교해서 더 적은 비용을 선택한다
- 좌우 이동을 하면서 연속된 단어를 찾고 끝나는 지점을 찾는다
- 두 경우의 이동수를 비교해서 최소값을 찾는다
- 상하 이동 + 좌우 이동의 최소값끼리 더한다
  
```
var answer = 0
        var n = name.length
        var minMove = n-1

        for (i in name.indices) {
            var up = name[i] - 'A'
            var down = 'Z' - name[i] + 1
            answer += min(up, down)
            
            var next = i + 1
           
            while (next < n && name[next] == 'A') {
                next++
            }

            minMove = min(i+i+n-next, minMove)
            minMove = min(minMove, (n-next)*2+i)
        }

        return answer + minMove
```

## :black_nib: **Review**

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/42860
