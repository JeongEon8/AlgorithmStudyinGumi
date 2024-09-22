# [백준 - s4] 12755. 수면장애

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학
- 구현
- 브루트포스 알고리즘

## :round_pushpin: **Logic**
몇번째부터 n자릿수인지 등을 판별하고 그 자릿수의 몇번째 수의 몇번째 숫자인지를 찾는다.

```java
int num = 1;
int subdigit = 9;
while (n > subdigit) {
	n -= subdigit;
	subdigit = (int) Math.pow(10, num++) * num * 9;
}
n--;
int cnt = (int) Math.pow(10, num - 1) + n / num;
String strCnt = Integer.toString(cnt);
char ans = strCnt.charAt(n % num);
```

## :black_nib: **Review**

처음엔 해시맵으로 0이되는 경우를 찾으려 했는데 테스트 케이스에 해시충돌로 시간초과가 발생하는 경우가 있는것 같다.

## 📡**Link**

https://www.acmicpc.net/problem/12755
