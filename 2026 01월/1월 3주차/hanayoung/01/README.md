# [백준 - S3] 1929. 소수 구하기

## ⏰  **time**
30분

## :pushpin: **Algorithm**
구현, 수학

## ⏲️**Time Complexity**
$O(N√N)$

## :round_pushpin: **Logic**
1. 소수여부 판단 함수.
2. 2보다 작을 경우 소수 아님. 2일 경우 소수임. 짝수일 경우 소수 아님.
3. √n까지만 반복문을 돌고 나누어지면 소수 아님. 끝까지 탐색가능한 경우 소수임.
```java
    static boolean isPrime(int n) {
        if(n < 2) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;
        
        for(int i = 2; i * i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
```
4. idx는 M부터 시작되며 N까지 판단하여 소수일 경우 stringbuilder에 붙이기
```java
        while(idx <= N) {
            if(isPrime(idx) == true) sb.append(idx).append("\n");
            idx++;
        }
```

## :black_nib: **Review**
- 그냥 나누기로 했더니 시간 초과 잔뜩 나버림... 소수들만 담아서 나눠보기도 시도하였으나 역시 실패 !..

## 📡 Link
https://www.acmicpc.net/problem/1929
