
# [프로그래머스 - lv2] 두 큐 합 같게 만들기

## ⏰  **time**
60분


## ⏲️**Time Complexity**
$O(N)$

## 풀이 

1. Q1의 합이 `total`보다 작으면 Q2의 값을 꺼내 Q1에 넣는다.
   - `total`은 두 큐의 합의 절반
2. 마찬가지로 Q1의 합이 더 커지면, Q1의 값을 Q2에 넣는다.
3. 이 과정을 3번 반복할 때까지 끝나지 않는다면 `-1` 출력

```java
while(q1_sum != total) {
            
    if (answer > (queue1.length + queue2.length) * 3) {
       return -1;
    }
            
    if (q1_sum < total) {
        long insert = q2.poll();
        q1.add(insert);
        q2_sum -= insert;
        q1_sum += insert;
    } else {
        long insert = q1.poll();
        q2.add(insert);
        q1_sum -= insert;
        q2_sum += insert;
    }
     answer++;
}
```

## :black_nib: **Review**


## 📡**Link**
- https://school.programmers.co.kr/learn/courses/30/lessons/118667#

