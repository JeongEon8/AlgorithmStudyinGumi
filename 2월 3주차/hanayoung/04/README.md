# [백준 - S5] 1094. 막대기

## ⏰  **time**
20분

## :pushpin: **Algorithm**
수학

## ⏲️**Time Complexity**
$O(1)$

## :round_pushpin: **Logic**
1. 총 막대 길이 합을 관리할 변수 sum에 초기값 64로 생성
2. 우선순위큐에 초기 막대 길이인 64 삽입
```java
        int sum = 64;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(64);
```
3. sum이 X보다 클 때까지 반복
4. 가장 짧은 막대(pq의 가장 앞의 값)을 꺼내서 반을 나눈 것을 버리는 것이 X보다 크거나 같으면 제거
5. X보다 작으면 pq에 반으로 나눈 것 삽입
6. 공통적으로 pq에 반으로 나눈 것 삽입
```java
        while(sum > X) {
            int shortLen = pq.poll();
            if(sum - shortLen/2 >= X) {
                sum -= shortLen/2;
            } else pq.add(shortLen/2);
            pq.add(shortLen/2);
        }
```
7. pq의 크기가 붙이는 막대의 개수이므로 해당 값 출력
```java
System.out.println(pq.size());
```


## :black_nib: **Review**
- 문제 자체가 이해가 잘 안됐던 문제..! 하지만 간단했다! 더 높은 티어라면 더 복잡했겠지..?

## 📡 Link
https://www.acmicpc.net/problem/1094
