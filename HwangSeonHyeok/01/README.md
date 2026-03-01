# [백준 - S5] 30987. 하루 피부과

## ⏰ **time**

15분

## :pushpin: **Algorithm**
- 수학
- 미적분학

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
 
정의된 $f(x) = ax^2+bx+c$와 $g(x) = dx+e$를
$\displaystyle{\int_{x_1}^{x_2} \{ f(x) - g(x) \}\mathrm{d}x}$로 미리 적분하고 계산한 결과를 출력한다.
```java
static int F(int x) {
    return ((a / 3 * x + (b - d) / 2) * x + c - e) * x;

}
```

## :black_nib: **Review** 
적분하는 법을 잊어버렸다

## 📡**Link**
https://www.acmicpc.net/problem/30987