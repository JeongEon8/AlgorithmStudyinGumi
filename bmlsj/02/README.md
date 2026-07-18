# [PGS - Lv2] 02_k진수에서 소수 개수 구하기

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. k진수로 변환 후 0으로 분리한다.
2. 분리한 숫자 리스트 안의 숫자가 소수인지 확인하고 갯수를 +1 한다.
3. 소수 구하기
   - 수학적으로 어떤 수 $N$의 약수들은 $\sqrt{N}$을 기준으로 대칭 구조를 이룬다.
     따라서 2부터 $\sqrt{N}$ 이하의 수까지만 나누어 떨어지는지 확인한다.

```java
String[] change = Integer.toString(n, k).split("0");
for(String ch: change) {

    if (ch.equals("")) {
        continue;
    }

    long num = Long.parseLong(ch);
    if (isPrime(num)) {
        answer++;
    }
}
```

```java
static boolean isPrime(long num) {
    if (num < 2) return false;
    for (long i = 2; i * i <= num; i++) {
        if (num % i == 0) return false;
    }
    return true;
}
```

## :black_nib: **Review**

## 📡 Link

- <https://school.programmers.co.kr/learn/courses/30/lessons/92335>
