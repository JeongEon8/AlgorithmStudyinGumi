# [백준 - S2] 1874. 스택 수열

## ⏰ **time**

70분

## ⏲️**Time Complexity**

$O(N)$

## :round_pushpin: **Logic**

1. 다음에 push할 숫자(`nextPush`)를 1부터 시작해 순차적으로 관리한다.
2. 목표 숫자(`target`)가 나올 때까지 스택에 push한다.
3. 스택의 top이 `target`과 같으면 `pop`한다.
4. 다르면 해당 수열은 구성 불가능하다

```java
Stack<Integer> st = new Stack<Integer>();
StringBuilder sb = new StringBuilder();
int nextPush = 1;

for (int target : input) {
	while (nextPush <= target) {
		st.add(nextPush);
		sb.append("+\n");
		nextPush++;
	}

	if (st.peek() == target) {
		sb.append("-\n");
		st.pop();
	} else {
		sb = new StringBuilder();
		sb.append("NO");
		break;
	}
}

System.out.println(sb.toString());
```

## :black_nib: Review

## 📡**Link**

- [https://www.acmicpc.net/problem/1874](https://www.acmicpc.net/problem/1874)
