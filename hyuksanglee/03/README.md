# [백준 - 골드 4] 7662. 이중 우선순위 큐 
 
## ⏰  **time**
1시간 30분

## :pushpin: **Algorithm**
우선순위 큐

## ⏲️**Time Complexity**
$O(log N)$

## :round_pushpin: **Logic**
1. 최댓값 뽑는 큐랑 최솟값 뽑는 큐, 큐에 삭제되지 않은 값 저장하는 map.
2. I를 받으면 max큐와 min큐에 숫자를 넣는다.
3. D를 입력 받으면 1이면 max큐에서 값을 뽑고 -1이면 min 큐에서 값을 뽑는다.
   - 큐에서 값 뽑을때는 map에 있는 값이 나올때 까지 뽑는다
4. 최종적으로 max와 min에서 map 없는 값을 삭제 해주면서 max와 mind에서 하나씩 뽑아서 출력해준다.
```java
	static void remove(PriorityQueue<Integer> que, Map<Integer, Integer> map) {
        while (!que.isEmpty()) {
            int val = que.poll();
            if (map.containsKey(val)) {
                map.put(val, map.get(val) - 1);
                if (map.get(val) == 0) map.remove(val);
                break;
            }
        }
    }
	
	static void clean(PriorityQueue<Integer> que, Map<Integer, Integer> map) {
        while (!que.isEmpty() && !map.containsKey(que.peek())) {
			que.poll();
        }
    }
```

## :black_nib: **Review**
- 골드4 아닌거 같아요 너무 어려운데요

## 📡 Link
https://www.acmicpc.net/problem/7662
