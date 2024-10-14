# [백준 - S3] 1966. 프린터 큐

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 구현
- 시뮬레이션
- 자류구조
- 큐

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

그대로 구현...

```
if (q.front().second == m && pq.top() == q.front().first)break;
            if(q.front().first==pq.top()){
                q.pop();
                pq.pop();
                answer++;
            }else {
                q.push(q.front());
                q.pop();
            }
        }

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/1966  
