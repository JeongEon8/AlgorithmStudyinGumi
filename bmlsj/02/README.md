# [프로그래머스 - Lv3] 이중우선순위큐

## ⏰  **time**
30분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(NlogN)$

- Counter : $O(N)$
- sorted() : $O(NlogN)$

## :round_pushpin: **Logic**

1. 최대힙과 최소힙을 구현하기 위해 PriorityQueue를 사용한다.
2. 명령어가 `I`이면 `min`, `max` 두 큐 모두에 삽입한다.
3. 명령어가 `D`이면:
   - `num == 1` → 최대힙에서 값을 제거하고, 최소힙에서도 제거
   - `num == -1` → 최소힙에서 값을 제거하고, 최대힙에서도 제거
4. 모든 연산 후 큐가 비어있으면 `[0, 0]` 반환, 아니면 `[최대값, 최소값]` 반환


```java
import java.util.*;
class Solution {
    
    public int[] solution(String[] operations) {
       
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < operations.length; i++) {
            String[] split = operations[i].split(" ");
            int num = Integer.parseInt(split[1]);
            
            if (split[0].equals("I")) {
                min.offer(num);
                max.offer(num);
            } else if (split[0].equals("D")) {
                if (min.isEmpty() || max.isEmpty()) continue;
                
                if (num == 1) {  // 최댓값 제거
                    int v = max.poll();
                    min.remove(v);
                } else if (num == -1){
                    int v = min.poll();
                    max.remove(v);
                }
            }
        }
        
        
       if (min.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{max.peek(), min.peek()};
    }
}
```

## :black_nib: **Review**



## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=java
