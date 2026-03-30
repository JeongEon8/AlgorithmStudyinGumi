# [백준 - S4] 28446. 볼링공 찾아주기 (Easy)

## ⏰ **time**

50분

## :pushpin: **Algorithm**

- 자료 구조
- 집합과 맵
- 해시를 사용한 집합과 맵
- 트리를 사용한 집합과 맵

## ⏲️**Time Complexity**

$O(M)$

## :round_pushpin: **Logic**

이 문제는 볼링공의 무게를 이용해 해당 공이 들어있는 사물함 번호를 빠르게 찾는 문제입니다.

명령은 두 가지로 구성됩니다.
1 i w : 무게 w인 볼링공을 i번 사물함에 넣는다.
2 w : 무게 w인 볼링공이 들어있는 사물함 번호를 출력한다.

여기서 무게 w를 통해 사물함 번호를 빠르게 찾아야 하므로 키-값 형태의 자료구조인 HashMap을 사용했습니다.
HashMap<Integer, Integer>에서 key : 볼링공의 무게 w, value : 사물함 번호 i 로 저장하도록 구성했습니다.

명령이 1인 경우에는 hashmap.put(weight, lockerIndex)를 통해 해당 무게의 볼링공이 들어있는 사물함 번호를 저장합니다.
명령이 2인 경우에는 hashmap.get(weight)을 이용해 해당 무게의 볼링공이 들어있는 사물함 번호를 조회하여 출력합니다.

```java
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int command = Integer.parseInt(st.nextToken());

			if (command == 1) {
				int lockerIndex = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				hashmap.put(weight, lockerIndex);
			} else {
				int weight = Integer.parseInt(st.nextToken());
				sb.append(hashmap.get(weight)).append("\n");
			}
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/28446
