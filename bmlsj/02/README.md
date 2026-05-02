# [PGS - lv2] 02_N개의 최소공배수

## ⏰**time**

30분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
- $lcm(a, b) = |a * b| / gcd(a, b)$ 공식 사용
- `두 수의 곱 / 최대 공약수`

```java
public int solution(int[] arr) {
        int answer =arr[0];

        // lcm(a, b) = |a * b| / gcd(a, b)
        for(int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }

    static int gcd(int a, int b) {
        while(b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }

        return a;
    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
```

## :black_nib: **Review**

## 📡 Link

<https://school.programmers.co.kr/learn/courses/30/lessons/12953>

```

```
