# [백준 - S5] 17269. 이름궁합 테스트

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 수학
- 구현
- 사칙연산

## ⏲️**Time Complexity**

$O(N^2)$

## :round_pushpin: **Logic**
한번 수행할때마다 1개씩 압축되므로 두 이름의 길이합-2번동안 궁합 테스트를 하면 된다.
```java
for (int i = total; i > 2; i--) {
    for (int j = 0; j < i - 1; j++) {
        testArr[j] = (testArr[j] + testArr[j + 1]) % 10;
    }
}
System.out.println(testArr[0] * 10 + testArr[1] + "%");
```

## :black_nib: **Review** 


## 📡**Link**
https://www.acmicpc.net/problem/17269