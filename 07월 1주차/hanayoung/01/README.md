# [백준 - S5] 10815. 숫자 카드

## ⏰  **time**
15분

## :pushpin: **Algorithm**
자료구조

## ⏲️**Time Complexity**
$O(n+m)$

## :round_pushpin: **Logic**
1. 출현가능한 모든 수를 담는 배열 생성
```java
boolean[] nums = new boolean[20000001];
```
2. 배열에 담을 수 있게 10000000을 더해서 배열의 해당 인덱스 true로 변경
```java
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken())+10000000;
            nums[tmp] = true;
        }
```
3. 10000000을 더한 인덱스로 찔렀을 때 value가 false이면 "0 ", true면 "1 "을 stringBuilder에 append
```java
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken())+10000000;
            if(nums[target] == false) sb.append("0 ");
            else sb.append("1 ");
        }

```

## :black_nib: **Review**
- StringBuilder랑 친해지는 중~..
- 냅다 배열로 해도 메모리 안 터진다 야호 ~

## 📡 Link
https://www.acmicpc.net/problem/10815
