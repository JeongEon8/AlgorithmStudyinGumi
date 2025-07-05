
# [백준 - S2] 1406. 에디터
 
## ⏰  **time**
30분

## :pushpin: **Algorithm**
BFS

## ⏲️**Time Complexity**
$O(N + M)$

## :round_pushpin: **Logic**

- stack 2개를 활용해 풀이
- 커서보다 왼쪽에 위치한 문자들은 `left`에 오른쪽에 위치한 문자는 `right`에 추가

```java
Stack<Character> left = new Stack<>();
Stack<Character> right = new Stack<>();

// 초기 문자열 => 왼쪽 스택
for (char c : input.toCharArray()) {
	left.push(c);
}

int t = Integer.parseInt(br.readLine());

for (int i = 0; i < t; i++) {

    String[] split = br.readLine().split(" ");

	switch (split[0]) {
	case "P": // $ 라는 문자 왼쪽에 추가
		left.push(split[1].charAt(0));
		break;

	case "L": // 커서 왼쪽으로 한칸
		if (!left.isEmpty()) {
			right.push(left.pop());
		}
		break;

	case "D": // 커서를 오른쪽으로 한칸
		if (!right.isEmpty()) {
			left.push(right.pop());
		}
		break;

	case "B": // 커서 왼쪽 문자 삭제
		if (!left.isEmpty()) {
			left.pop();
		}
		break;

	default:
		break;
	}
}

StringBuilder sb = new StringBuilder();
for (char l : left) {
	sb.append(l);
}

while (!right.isEmpty()) {  // right는 역순으로 출력
	sb.append(right.pop());
}

System.out.println(sb.toString());
```


## :black_nib: **Review**
- Stack으로 풀라고 되어 있었는데, 그냥 배열로 풀었다가 시간 초과를 맛봤다. 흥


## 📡**Link**
- https://www.acmicpc.net/problem/1406