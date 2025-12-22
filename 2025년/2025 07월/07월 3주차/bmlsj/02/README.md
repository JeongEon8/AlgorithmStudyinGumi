# [백준 - S5] 10431. 줄세우기
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
정렬

## ⏲️**Time Complexity**

- 최악의 경우: $O(N²)$

	→ 배열이 역순일 때, 한 요소를 삽입할 때마다 거의 모든 요소를 뒤로 밀어야 하기 때문.

- 최선의 경우: $O(N)$

	→ 이미 정렬된 경우에는 한 번도 이동하지 않음.

## :round_pushpin: **Logic**
- `key`: 지금 정렬하려는 학생의 키.
- `j`: `key`의 왼쪽에서 `key`보다 큰 학생들을 찾기 위해 탐색.
- `students[j + 1] = students[j]` : 큰 학생을 뒤로 한 칸 이동.
- `cnt++`: 한 번 이동할 때마다 1회 이동으로 카운트.


```java
public static int stand(int[] students) {

	int cnt = 0;

	for (int i = 1; i < students.length; i++) {
		int key = students[i];
		int j = i - 1;

		// key보다 큰 값들을 한 칸씩 뒤로 미루기
		while (j >= 0 && students[j] > key) {
			students[j + 1] = students[j];
			j--;
			cnt++;
		}

		students[j + 1] = key;
			
	}

	return cnt;

}
```

## :black_nib: **Review**


## 📡**Link**
- https://www.acmicpc.net/problem/10431
