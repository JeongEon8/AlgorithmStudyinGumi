# [프로그래머스 - Lv2] 42587. 프로세스

## ⏰ **time**
10분

## :pushpin: **Algorithm**
우선순위 큐

## ⏲️ **Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 우선순위 큐에 우선순위를 넣고 그냥 큐에 순서와 우선순위를 넣는다.
2. 그냥 큐를 하나씩 돌면서 우선순위가 높은지 확인하고 location과 비교하며 찾으려는 것을 찾아 출력한다.
```cpp
    while(true){
        pair<int, int> tmp = q.front();
        q.pop();
        
        if(tmp.second != pq.top()){
            q.push(tmp);
        }
        else{
            if(tmp.first == location){
                answer = cnt;
                break;
            }
            else{
                cnt++;
                pq.pop();
            }
        }
    }
```

## :black_nib: **Review**
- 여러분 나가사키 가보신 적 있나요?
- 사라 우동이라는 음식이 있는데요, 정말 맛있어요. 꼭 먹어보세요!
<img width="400" height="300" alt="image" src="https://github.com/user-attachments/assets/a0de69e3-4e5c-4b22-9c25-4fe558497e7b" />


## 📡 Link
[프로그래머스 레벨2 프로세스](https://school.programmers.co.kr/learn/courses/30/lessons/42587)
