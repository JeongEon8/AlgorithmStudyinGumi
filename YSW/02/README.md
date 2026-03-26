# [백준 - S2] 4358. 생태학 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 자료 구조
- 문자열
- 집합과 맵
- 해시를 사용한 집합과 맵
- 트리를 사용한 집합과 맵

## ⏲️**Time Complexity**

$O(N + MlogM)$
N : 전체 입력 개수
M : 나무 종류

## :round_pushpin: **Logic**

입력으로 주어지는 나무 이름을 해시맵을 이용해 종류별 등장 횟수를 카운팅하고, 전체 나무의 개수를 별도로 저장한다. 이후 나무 이름들을 사전순으로 정렬한 뒤, 각 나무의 등장 횟수를 전체 개수로 나누어 백분율을 계산하고 출력한다.

```java
		ArrayList<String> list = new ArrayList<String>(hashmap.keySet());
		Collections.sort(list);

		for (String key : list) {
			double percent = (double) hashmap.get(key) * 100 / totalCount;
			sb.append(key).append(" ").append(String.format("%.4f", percent)).append("\n");
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/4358
