# [백준 - S4] 10773. 제로

## ⏰  **time**
10분

## :pushpin: **Algorithm**
스택

## ⏲️**Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. 입력받을 K개만큼 반복
2. 입력받은 수가 0이라면 꺼내고, 아니라면 담기
```java
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(bf.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(num == 0) stack.pop();
            else stack.push(num);
        }
```
3. 스택이 빌 때까지 반복하며 answer에 값 더하기
```java
        while(stack.size() > 0) {
            answer += stack.pop();
        }
```

## :black_nib: **Review**
- 완전 스택이요 !! 하던 문제 야호

## 📡 Link
https://www.acmicpc.net/problem/10773
