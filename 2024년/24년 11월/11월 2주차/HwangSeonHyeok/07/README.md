# [백준 - G4] 17943. 도미노 예측

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 수학
- 누적 합
- 비트 연산

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

$1\oplus2$와$2\oplus3$을 XOR연산하면 같은 $2\oplus2$는 0으로 사라진다 즉 $1\oplus2\oplus2\oplus3=1\oplus3$이된다.  
이런식으로 XOR을 누적하면서 연산하면 $1\oplus n$을 구해 둘 수 있다.  
$a\oplus b$는 $1 \oplus a \oplus 1 \oplus b = a\oplus b$를 통해서 주어진 a와 b의 XOR연산 값을 구하는 0번 커맨드를 수행 할 수 있다. 1번 커맨드를 진행한경우 $a \oplus a \oplus b = b$임을 이용하여 구할 수 있다.

```java
	static int q1(int x, int y) {
		return xor[x] ^ xor[y];
	}

	static int q2(int x, int y, int d) {
		return xor[x] ^ xor[y] ^ d;
	}

	xor = new int[n + 2];
	split = in.readLine().split(" ");
	for (int i = 0; i < n - 1; i++) {
		xor[i + 2] = xor[i + 1] ^ Integer.parseInt(split[i]);
	}

	for (int i = 0; i < q; i++) {
		split = in.readLine().split(" ");
		int cmd = Integer.parseInt(split[0]);
		int x = Integer.parseInt(split[1]);
		int y = Integer.parseInt(split[2]);
		if (cmd == 0) {
			sb.append(q1(x, y) + "\n");
		} else if (cmd == 1) {
			int d = Integer.parseInt(split[3]);
			sb.append(q2(x, y, d) + "\n");
		}
	}

```

## :black_nib: **Review**

최근 풀었던 전구문제에서 XOR에 대해 공부한게 도움이 된것같다.

## 📡**Link**

https://www.acmicpc.net/problem/17943
