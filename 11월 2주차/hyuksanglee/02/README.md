# [PGS - Lv2] 02_프로세스

## ⏰**time**

- 26분

## :pushpin: **Algorithm**

- 큐

## ⏲️**Time Complexity**

$O(N)$ 

## :round_pushpin: **Logic**

1. 큐에 하나씩 담는다
2. 큐에서 하나씩 꺼내서 뒤에 비용이랑 비교하고 큰값이 있으면 큐에 다시 넣는다
   ```
   while (!queue.isEmpty()) {
               Info info = queue.poll();
   
               if (info.price < pq.peek()) {
                   queue.offer(info);
                   continue;
               }
   
               pq.poll();
               answer++;
   
               if (info.index == location) {
                   return answer;
               }
           }
   ```

3. 큐에 큰 값이 없을경우 넣지 않고 카운트 올려주고 index 값이랑 비교 해서 같으면 카운트 횟수 리턴

## :black_nib: **Review**

- 문제를 잘못 이해해서 처음에는 우선순위 큐로 풀다가 틀렸어요

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/42587
