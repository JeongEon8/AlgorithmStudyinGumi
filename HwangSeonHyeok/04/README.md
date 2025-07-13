# [백준 - S4] 24417. 알고리즘 수업 - 피보나치 수 2

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학
- 다이나믹 프로그래밍

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
코드 1은 피보나치n번 호출되고 코드 2는 n-3번 호출된다.
```java
static int fib(int n) {
    f[1] = 1;
    f[2] = 1;
    for (int i = 3; i <= n; i++) {
        f[i] = (f[i - 1] + f[i - 2]) % 1000000007;
    }

    return f[n];
}

public static void main(String[] args) throws Exception {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(in.readLine());
    f = new int[n + 1];
    System.out.println(fib(n) + " " + (n - 2));
}
```  
## :black_nib: **Review**
이게 왜 TLE가 안뜨지?

## 📡**Link**
https://www.acmicpc.net/problem/24417