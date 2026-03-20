# [백준 - 실버4] 10610. 30

## ⏰ **time**

30분

## :pushpin: **Algorithm**

그리디

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

주어진 숫자의 각 자리수를 이용해 30의 배수 중 가장 큰 수를 만드는 문제

- 30 배수의 조건: 반드시 0이 하나 있고, 모든 자리수의 합이 3의 배수일 것
  조건을 만족하는 숫자들을 내림차순으로 나열하면, 가장 큰 수가 된다.

```java
boolean zeroCheck = false;
int digit = 0, idx = 0;
int[] numList = new int[input.length()];
for (char num : input.toCharArray()) {
    if (num == '0') {
        zeroCheck = true;
    }
    numList[idx++] = num - '0';
    digit += num - '0';
}

if (!zeroCheck)
    System.out.println("-1");
else if (digit % 3 != 0) {
    System.out.println("-1");
} else {
    Arrays.sort(numList);

    for (int i = numList.length - 1; i >= 0; i--) {
        System.out.print(numList[i]);
    }
}
```

## :black_nib: **Review**

## 📡**Link**

<https://www.acmicpc.net/problem/10610>
