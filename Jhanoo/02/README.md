# [프로그래머스 - Lv2] 숫자의 표현

## ⏰**time**

40분

## :pushpin: **Algorithm**

- 수학
- 약수 나열

## ⏲️**Time Complexity**

$O(\sqrt{n})$  
(\(2n\)의 약수는 최대 $O(\sqrt{n})$개 수준에서 처리)

## :round_pushpin: **Logic**

1. 자연수 `n`을 길이 `k`인 연속 자연수의 합으로 쓰면  
   \(n = ka + \frac{k(k-1)}{2}\) 이고, 정리하면 \(2n = k(2a + k - 1)\) 형태가 된다.  
   즉 `k`와 `(2n)/k`는 `2n`의 한 쌍의 약수가 된다.

2. `i`를 1부터 올리며 `2 * n % i == 0`일 때 약수 쌍 `(i, 2n/i)`를 리스트에 넣는다.

```java
for (int i = 1; i * i < 2 * n; i++) {
    if (2 * n % i == 0) {
        divisors.add(i);
        divisors.add(2 * n / i);
        cnt++;
    }
}
```

3. 저장된 각 쌍 `(d1, d2)`에 대해 `(d2 - d1 + 1) % 2 == 0`이면,  
   그에 대응하는 연속합 표현이 자연수 `a`로 존재하므로 경우의 수를 1 증가시킨다.

```java
if ((d2 - d1 + 1) % 2 == 0) {
    answer++;
}
```

4. 누적한 `answer`를 반환한다.

## :black_nib: **Review**

- 처음에 \(n = k(a + \frac{k-1}{2})\) 까지만 정리하고 풀려 했더니 k가 짝수인 경우 즉, k = 2일 때, \(a + (a+1)\) 를 다룰 수 없었다. 그래서 양변에 2를 곱하여 2n의 약수의 곱으로 풀이하니 해결됐다!

## 📡 Link

https://school.programmers.co.kr/learn/courses/30/lessons/12924
