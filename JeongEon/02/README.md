# [백준 - S2] 10799. 쇠막대기

## ⏰  **time**
5분

## :pushpin: **Algorithm**
스택

## ⏲️**Time Complexity**
$O(n)$

## :round_pushpin: **Logic**
1. 열린거 다음에 바로 닫힌거 나오면 레이저로 간주, 그 외에는 쇠막대기
2. 레이저가 나오면 -> 여태 쌓인 쇠막대기 스택의 크기를 더한다.
3. 파이프가 닫히면 -> 총 파이프 개수를 늘리고, 파이프 스택에서 뺀다.
```cpp
	for (int i = 0; i < str.size(); i++) {
		if (str[i] == '(' && str[i + 1] == ')') {
			cnt += s.size();
			i++;
		}
		else if (str[i] == '(') {
			s.push(i);
		}
		else if (str[i] == ')') {
			cnt++;
			s.pop();
		}
	}
```

## :black_nib: **Review**
- 이거 언제 해본거 같은데..?

## 📡 Link
https://www.acmicpc.net/problem/10799
