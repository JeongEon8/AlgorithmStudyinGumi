# [백준 - S2] 30619. 내 집 마련하기 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 구현
- 정렬

## ⏲️**Time Complexity**

$O(Q*N*logN)$

## :round_pushpin: **Logic**

처음 주어지는 배열의 인덱스가 방 기준으로 사람의 번호가 주어지는데, L, R이 사람 기준으로 정렬을 하기 때문에 이걸 사람 기준으로 방 번호를 가진 배열로 바꿔서 L, R에 대한 정렬을 진행하는 식으로 구현했다.

```java
		for (int i = 0; i < N; i++) {
			roomArr[i] = Integer.parseInt(strArr[i]);
			peopleArr[roomArr[i] - 1] = i + 1;
		}

		for (int i = 0; i < query; i++) {
			strArr = br.readLine().split(" ");
			int L = Integer.parseInt(strArr[0]);
			int R = Integer.parseInt(strArr[1]);
			int[] copyPeopleArr = Arrays.copyOf(peopleArr, peopleArr.length);
			Arrays.sort(copyPeopleArr, L - 1, R);

			for (int j = 0; j < N; j++) {
				roomArr[copyPeopleArr[j] - 1] = j + 1;
			}

			for (int j = 0; j < N; j++) {
				System.out.print(roomArr[j] + " ");
			}
			System.out.println();
		}
```

## :black_nib: **Review**

문제를 이해하는데 힘들었다. 너무 헷갈리게 문제를 써 놓은 거 같다.

## 📡**Link**

https://www.acmicpc.net/problem/30619
