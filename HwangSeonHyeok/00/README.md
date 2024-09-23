# [백준 - g5] 14567. 선수과목

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 다이나믹 프로그래밍
- 그래프 이론
- 위상 정렬
- 방향 비순환 그래프

## :round_pushpin: **Logic**

과목의 번호, 선수과목수, 최소 학기, 후과목리스트를 저장하는 객체를 만들고 꺼낼때 지금까지 선행과목중 가장 학기수가 큰 경우+1을 기록한다

```java
static class Subject {
	int num, back, semester;
	List<Integer> next;

	public Subject(int num) {
		this.num = num;
		this.back = 0;
		this.semester = 1;
		this.next = new ArrayList<>();
	}
}
int[] ans = new int[n + 1];
while (!q.isEmpty()) {
	Subject current = q.poll();
	ans[current.num] = current.semester;
	for (int snum : current.next) {
		subjectArr[snum].back--;
		if (current.semester >= subjectArr[snum].semester) {
			subjectArr[snum].semester = current.semester + 1;
		}
		if (subjectArr[snum].back == 0) {
			q.add(subjectArr[snum]);
		}
	}
}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/14567
