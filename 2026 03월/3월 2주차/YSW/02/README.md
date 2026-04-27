# [백준 - G5] 27087. 직육면체 (Easy)

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 수학
- 정수론

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**

A*B*C 모양의 직육면체가 주어졌을 때 1*p*p 모양의 직육면체로 A*B*C 모양의 직육면체를 채울수 있는지 판별하는 문제였다.
1*p*p로 A*B*C 모양의 직육면체가를 채울려면 A,B,C중에 2개 이상이 p의 배수여야 하므로 p의 배수인지 판별해서 2개 이상인지 확인한다.

```java
			if (A % p == 0)
				count++;
			if (B % p == 0)
				count++;
			if (C % p == 0)
				count++;

			sb.append(count >= 2 ? 1 : 0).append("\n");
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/27087
