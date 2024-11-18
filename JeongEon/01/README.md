# [백준 - 실버 4] 1758. 알바생 강호
 
## ⏰  **time**
10분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**
$O(Nlog(N))$

## :round_pushpin: **Logic**
1. 팁을 가장 많이 받고 싶다면, 팁을 많이 주고 싶은 사람들 순으로 정렬하면 된다.
2. 음수가 되지 않는 선에서 sum에 계속 팁을 더해주면 된다.
3. 하지만 값을 더하다 보면 integer범위를 벗어날 수 있으므로 long long 자료형을 사용해야한다.
   ```cpp
	long long  sum = 0;
	for (int i = 0; i < N; i++) {
		int money = tips[i] - ((i + 1) - 1);
		if (money <= 0) {
			money = 0;
		}

		sum += money;
	}
   ```

## :black_nib: **Review**
- long long으로 안해서 틀렸다.. 힝

## 📡 Link
https://www.acmicpc.net/problem/1758
