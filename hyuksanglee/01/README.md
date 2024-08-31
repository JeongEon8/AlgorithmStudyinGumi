# [백준 - S2] 4948. 베르트랑 공준
 
## ⏰  **time**
40븐

## :pushpin: **Algorithm**
에라토스테네스의 체

## :round_pushpin: **Logic**
- 2n의 크기 만큼 배열 생성한다.

- 2부터 2n까지 for문을 돌면서 배열의 해당 칸에 false이면 해당 인덱스의 제곱을 다 true로 바꾸어준다

```java
// 에라토스테네스의 체
		for (long i = 2; i < MAX_LEN; i++) {
			if (prime[(int)i] == false) {
				for (long j = i * i; j < MAX_LEN; j += i) {
					prime[(int)j]=true;

				}
			}
		}
```

## :black_nib: **Review**
- 처음에는 for문을 돌때 int로 주니 숫자가 커지면 음수가되어 무한 루프에 빠졌음

## 📡**Link**
- https://www.acmicpc.net/problem/4948
