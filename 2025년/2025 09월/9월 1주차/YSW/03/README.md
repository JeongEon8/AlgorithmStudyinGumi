# [백준 - S3] 22233. 가희와 키워드 (Easy)

## ⏰ **time**

30분

## :pushpin: **Algorithm**

- 자료 구조
- 문자열
- 집합과 맵
- 해시를 사용한 집합과 맵
- 파싱

## ⏲️**Time Complexity**

$O(M * 블로그 키워드 개수)$

## :round_pushpin: **Logic**

HashMap에 메모장의 키워드를 입력하고 블로그에서 키워드를 쓴 것들중에 메모장에 포함되어 있으면 삭제하는 식으로 구현했다.

```java
		for (int i = 0; i < M; i++) {
			strArr = br.readLine().split(",");
			for (int j = 0; j < strArr.length; j++) {
				if (map.containsKey(strArr[j])) {
					map.remove(strArr[j]);
				}
			}
			sb.append(map.size()).append("\n");
		}
```

## :black_nib: **Review**

처음에 삭제 안하고 1, 0 으로 구분했다가 시간초과가 발생했었다.

## 📡**Link**

https://www.acmicpc.net/problem/22233
