# [프로그래머스 - lv2] 과제 진행하기

## ⏰  **time**
20분

## :pushpin: **Algorithm**
우선순위 큐

## ⏲️**Time Complexity**
$O(N log N)$

## :round_pushpin: **Logic**
- 스킬을 사용하지 않고 최대한 간다.
- 그리고 라운드 마다 우선순위 큐에 담는다.
- 병사수가 마이너스가 되었을경우
    - 스킬 하나 사용하고 큐에서 하나 뽑아서 더해준다.
    - 이거를 음수가 아니거나 스킬수가 0이 아닐때까지 반복한다.
```java
PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int l = 0; l<len; l++){
            answer++;
            int e = enemy[l];
            n -= e;
            pq.add(e);
            if(n<0){
                while(n<0 && k>0){
                    int s = pq.poll();
                    n+=s;
                    k--;
                }
            }
            
            if(n<0 && k<=0){
                return answer-1;
            }
        }
```

## :black_nib: **Review**
- 처음에는 dp로 풀려고 했는데 풀이가 생각이 안나서 그리디로 풀었어요

## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/142085
