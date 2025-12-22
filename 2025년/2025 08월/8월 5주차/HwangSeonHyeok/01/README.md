# [백준 - S3] 6571. 피보나치 수의 개수 

## ⏰ **time**

25분

## :pushpin: **Algorithm**
- 수학
- 다이나믹 프로그래밍
- 임의 정밀도 / 큰 수 연산

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
$10^100$까지 나올 수 있으므로 BigInteger로 피보나치 수를 미리 계산하고 범위 사이인 피보나치 수를 카운팅하면된다.
```java
while (true) {
    BigInteger f1 = fibo.get(n - 1);
    BigInteger f2 = fibo.get(n - 2);
    fibo.add(f1.add(f2));
    if (fibo.get(n).compareTo(max) > 0) {
        break;
    }
    n++;
}
while (true) {
    StringTokenizer st = new StringTokenizer(in.readLine());
    BigInteger a = new BigInteger(st.nextToken());
    BigInteger b = new BigInteger(st.nextToken());
    if (a.equals(BigInteger.ZERO) && b.equals(BigInteger.ZERO)) {
        break;
    }
    int cnt = 0;
    for (BigInteger f : fibo) {
        if (a.compareTo(f) <= 0 && b.compareTo(f) >= 0) {
            cnt++;
        }
    }
    sb.append(cnt).append("\n");
}
```

## :black_nib: **Review**  
BigInteger를 쓰는 특이한 문제
## 📡**Link**
https://www.acmicpc.net/problem/6571