# [백준 - g4] 27172. 수 나누기 게임

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 수학
- 브루트포스 알고리즘
- 정수론
- 소수 판정
- 에라토스테네스의 체

## :round_pushpin: **Logic**

입력의 최대까지 에라토스테네스의 체처럼 카드의 수의 배수들 중 사람들에게 나눠준 카드인지 판별하고 맞는경우 스코어 증감을 해주는 방식으로 풀었다.

```java
		for (int i = 0; i < n; i++) {
			int current = cardArr[i] * 2;
			while (current <= max) {
				if (existCard[current] > 0) {
					score[existCard[current] - 1]--;
					score[i]++;
				}
				current += cardArr[i];
			}
		}
```

## :black_nib: **Review**

예전 보드게임 컵 참가 당시 마지막으로 풀다 포기한 문제  
처음 맞았을땐 실행시간이 2초가 넘었다.. 틀왜맞..  
한번에 처리할 수 있는것들을 줄여나가니까 시간을 많이 줄일 수 있었다.

## 📡**Link**

https://www.acmicpc.net/problem/27172
