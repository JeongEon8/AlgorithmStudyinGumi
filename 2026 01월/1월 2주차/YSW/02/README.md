# [백준 - S2] 18113. 그르다 김가놈 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 이분 탐색
- 매개 변수 탐색

## ⏲️**Time Complexity**

$O(N*logL)$

## :round_pushpin: **Logic**

김밥의 길이가 2K보다 길면 -2K를 자르고 손질된 김밥을 List에 추가한다. 2K보다 작고 K보다 크면 -K를 한 값을 List에 저장하고 나머지는 저장하지 않는다. 
이렇게 손질된 김밥들을 특정길이 P로 잘랐을때 M개 이상의 김밥을 만들어야 하는데 P가 최대한 길어야한다.
그러므로 P의 길이를 이진탐색으로 탐색해준다. P로 잘랐을때 M개이상이면 P값을 저장하고 low 값을 높인다. M개 이하라면 high의 값을 내린다.
이 과정을 low <= high 질때까지 반복해서 P 값을 찾아준다.

```java
		for (int i = 0; i < N; i++) {
			int L = Integer.parseInt(br.readLine());
			if (maxLen < L) {
				maxLen = L;
			}

			if (L >= 2 * K) {
				if (L - 2 * K > 0)
					list.add(L - 2 * K);
			} else if (L > K) {
				if (L - K > 0)
					list.add(L - K);
			}
		}

		if (list.isEmpty()) {
			System.out.println(-1);
			return;
		}

		int low = 1;
		int high = maxLen;
		int ans = -1;

		while (low <= high) {
			int mid = (low + high) / 2;

			long count = 0;
			for (int len : list) {
				count += (len / mid);
			}

			if (count >= M) {
				ans = mid;
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}

		System.out.println(ans);

```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/18113
