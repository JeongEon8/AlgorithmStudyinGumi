# [백준- G4] 17298. 오큰수

## ⏰  **time**
60분

## :pushpin: **Algorithm**
스택

## ⏲️**Time Complexity**
$O(N)$


## :round_pushpin: **Logic**

1. 스택에는 인덱스 저장. 처음에는 -1로 초기화한다.
2. 현재 인덱스를 스택에 저장하고, 현재 원소 `nums[i]`와 스택의 top을 비교한다
	- 만약 `nums[i]`가 스택의 top보다 크다면, 스택에서 pop하고 그 인덱스의 오큰수는 `nums[i]`이다.
3. 더 큰 수를 만나지 못한다면 stack에 들어가기만 하다가 큰 수를 만났을 때 모두 pop되어 나옴


```java
for (int i = 0; i < N; i++) {
	while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
		result[stack.pop()] = nums[i];
	}

	stack.push(i);
}

StringBuilder sb = new StringBuilder();
for (int re : result) {
	sb.append(re).append(" ");
}
```


## :black_nib: **Review**

`N`이 커서 $O(N^2)$으로는 불가능
시간 초과가 안나야하는데 난다면 StringBuilder를 한번 써보기

## 📡**Link**
- https://www.acmicpc.net/problem/17298