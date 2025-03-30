# [백준 - S5] 2303. 숫자 게임

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 구현
- 조합론론


## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**
5장중 3장을 뽑는 경우는 10가지 밖에 안되므로 가능한 모든 경우의 수를 세어 일의 자리가 최대가 되는 경우를 찾고 현제 기록해둔 최대값 이상이면 사람 번호를 갱신한다.
```java
int ans = 0;
int totalmax = 0;
for (int people = 1; people <= n; people++) {
	String[] split = in.readLine().split(" ");
	int[] card = new int[5];
	for (int i = 0; i < 5; i++) {
		card[i] = Integer.parseInt(split[i]);
	}
	int max = 0;
	for (int i = 0; i < 3; i++) {
		for (int j = i + 1; j < 4; j++) {
			for (int k = j + 1; k < 5; k++) {
				int sum = (card[i] + card[j] + card[k]) % 10;
				max = Math.max(max, sum);
			}
		}
	}
	if (max >= totalmax) {
		totalmax = max;
		ans = people;
	}
}
```

## :black_nib: **Review**  
카드 수가 적어서 조합으로 해결하였다. 

## 📡**Link**

https://www.acmicpc.net/problem/2303
