# [백준 - S2] 29336. 월향, 비상 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 그리디 알고리즘
- 정렬

## ⏲️**Time Complexity**

$O(NlogN + M)$

## :round_pushpin: **Logic**

능력치를 내림차순으로 정렬한 뒤, 각 날짜의 요구 품질을 만족할 때까지 가장 큰 능력부터 순차적으로 사용합니다. 능력은 한 번만 사용되며, 각 능력은 (능력치 + day) 만큼 기여합니다.
누적 레벨이 요구 문제의 품질 이상이 될 때까지 반복하고, 능력이 부족하면 실패합니다.

```java
		Arrays.sort(abilities);
		for (int i = 0; i < n / 2; i++) {
			long temp = abilities[i];
			abilities[i] = abilities[n - 1 - i];
			abilities[n - 1 - i] = temp;
		}

		long totalLevel = 0;
		int index = 0;
		long lastDay = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			long day = Long.parseLong(st.nextToken());
			long quality = Long.parseLong(st.nextToken());
			lastDay = day;

			while (totalLevel < quality) {
				if (index >= n) {
					System.out.println(-1);
					return;
				}
				totalLevel += abilities[index] + day;
				index++;
			}
		}

		for (int i = index; i < n; i++) {
			totalLevel += abilities[i] + lastDay;
		}

		System.out.println(totalLevel);
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/29336