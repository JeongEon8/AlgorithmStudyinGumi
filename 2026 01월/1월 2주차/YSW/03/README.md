# [백준 - S4] 33985. 그거 왜 말해! (Easy)

## ⏰ **time**

40분

## :pushpin: **Algorithm**

- 문자열
- 애드 혹

## ⏲️**Time Complexity**

$O(1)$

## :round_pushpin: **Logic**

길이가 N인 A, B로 이루어진 암호를 만드는데
암호 입력을 i(1 < i < N-1)번째에 A를 입력할수 있고 i번째에 입력하면 i+1번째는 B가 입력된다.
암호를 만들 수 있으면 Yes 못 만들면 No를 출력하면 된다.
암호 입력하는 범위 i가 1 < i < N-1 이기 때문에 
무조건 첫번째는 A만 올 수 있고 마지막은 B만 올 수 있기 때문에 암호의 첫번째고 A이고 마지막이 B이면 Yes 아니면 No를 출력한다.

```java
		if (input.charAt(input.length() - 1) == 'A'||input.charAt(0) == 'B') {
			System.out.println("No");
		} else {
			System.out.println("Yes");
		}
```

## :black_nib: **Review**

## 📡**Link**

https://www.acmicpc.net/problem/33985
