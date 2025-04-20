# [백준 - S5] 26517. 연속인가??

## ⏰ **time**

5분

## :pushpin: **Algorithm**

- 수학

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**
극한의 규칙대로  $\lim_{x \rightarrow t} f(x) = f(t)$에서 좌극한 우극한이 같은지 확인하면된다.
```java
long a = Long.parseLong(split[0]);
long b = Long.parseLong(split[1]);
long c = Long.parseLong(split[2]);
long d = Long.parseLong(split[3]);
long ans1 = a * k + b;
long ans2 = c * k + d;
if (ans1 == ans2) {
	System.out.println("Yes " + ans1);
} else {
	System.out.println("No");
}
```


## :black_nib: **Review**  
실버..?
## 📡**Link**

https://www.acmicpc.net/problem/26517
