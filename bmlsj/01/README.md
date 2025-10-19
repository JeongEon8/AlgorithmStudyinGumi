# [프로그래머스 - Lv2] 귤 고르기

## ⏰  **time**
15분

## :pushpin: **Algorithm**
그리디

## ⏲️**Time Complexity**
$O(NlogN)$

- Counter : $O(N)$
- sorted() : $O(NlogN)$

## :round_pushpin: **Logic**

많은 수부터 상자에 담으면 최소 종류의 수가 된다.

1. 전체 각 크기별 귤의 개수를 계산한다.
2. 많이 나온 순으로 정렬한다.
3. 큰 개수부터 하나씩 세어 총합이 `k` 이상이 될때까지 반복한다.
4. 담을 때마다 귤 종류인 `answer`를 1씩 증가시킨다.
   


```python
from collections import Counter

def solution(k, tangerine):
    answer = 0
    
    counter = Counter(tangerine)
    counts = sorted(counter.values(), reverse=True)
    
    total = 0
    for c in counts:
        total += c
        answer += 1
        if total >= k:
            break
    
    return answer
```

```java
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
        }
        
        List<Integer> keySet = new ArrayList<>(map.keySet());
        keySet.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o2) - map.get(o1);
            }
        });
        
        int total = 0;
        for (int key : keySet) {
            total += map.get(key);
            answer++;
            if (total >= k) {
                break;
            }
        }
        
        return answer;
    }
}
```

## :black_nib: **Review**

알고리즘 잠시 쉬었다고 다 까먹어 버린 사람...

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/138476?language=python3
