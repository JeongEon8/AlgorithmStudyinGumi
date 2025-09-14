# [백준 - S1] 14562. 태권왕 (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 그래프 이론
- 그래프 탐색
- 너비 우선 탐색

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

현재 상태에서 발차기A와 발차기B를 했을때 큐에 넣어주고,
visited.contains(nextA)로 중복제거 하고 nextA.S <= nextA.T로 불필요한 값을 넣지 않아서 가지치기하는 식으로 했다.

```java
			while (!queue.isEmpty()) {
				Record currentRecord = queue.poll();

				if (currentRecord.S == currentRecord.T) {
					System.out.println(currentRecord.count);
					break;
				}

				// 발차기 A인 경우
				Record nextA = new Record(currentRecord.S * 2, currentRecord.T + 3, currentRecord.count + 1);
				if (!visited.contains(nextA) && nextA.S <= nextA.T) {
					queue.add(nextA);
					visited.add(nextA);
				}

				// 발차기 B인 경우
				Record nextB = new Record(currentRecord.S + 1, currentRecord.T, currentRecord.count + 1);
				if (!visited.contains(nextB) && nextB.S <= nextB.T) {
					queue.add(nextB);
					visited.add(nextB);
				}
			}
```

## :black_nib: **Review**

visited.contains()를 할때 Class에 equals와 hashCode를 재정의 하지 않으면 Object에 있는 equals와 hashCode로 작동해서
객체의 메모리 주소를 기반으로 해시 코드를 생성되기 때문에 visited.contains()는 무조건 false가 나오게 되서 계속 추가하게 된다.
!visited.contains(nextB)를 안해줘도 풀리긴 하지만 해주는게 더 효율적이여서 해줬다.

## 📡**Link**

https://www.acmicpc.net/problem/14562
