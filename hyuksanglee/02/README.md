# [프로그래머스 - lv2] 178870. 연속된 부분 수열의 합

## ⏰**time**
30분

## :pushpin: **Algorithm**
* 큐

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 정렬되어 있는 배열을 역순으로 뽑는다
2. 큐에 저장하고 total 변수에 더해준다.
3. total이 k보다 크면 큐에서 하나씩 빼주고 total에서 그 값을 빼준다.
4. total이 k일 경우 큐의 사이즈를 가져와서 이전에 정답 사이즈 값이랑 비교 하여 작거나 같을 경우 큐에 저장된 인덱스 값 저장
     - for문으로 정렬된 배열을 역순으로 돌기 때문에 for문의 인덱스를 시작 인덱스로 잡고 사이즈를 더해서 마지막 인덱스로 잡아준다.

```
Queue<Integer> que = new ArrayDeque<Integer>();
        for(int l = len-1; l>=0; l--){
            int n = sequence[l];
            total+= n;
            que.add(n);
            while(total>k && !que.isEmpty()){
                total -= que.poll();
            }
            if(total == k){
                if(size >= que.size()){
                  size = que.size();
                    a = l;
                    b = l+size-1;
                }
            }
            
        }
```

## :black_nib: **Review**
- 오랜만에 알고리즘~~~

## 📡 Link
https://school.programmers.co.kr/learn/courses/30/lessons/178870
