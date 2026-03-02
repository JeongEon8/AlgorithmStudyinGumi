# [백준 - 실버 3] 1213.팰린드롬 만들기

## ⏰ **time**
28분

## :pushpin: **Algorithm**
팰린드롬, 그리디

## ⏲️ **Time Complexity**
$O(N)$

## :round_pushpin: **Logic**
1. input 문자열을 돌면서 알파벳별로 개수를 카운트한다.
2. 알파벳순서대로 돌면서 1개 초과인 알파벳을 큐와 스택에 하나씩 넣는다.
3. 그후, 다시 A부터 1개 초과인지 판단하며 반복한다.
4. 1개씩 남은 알파벳들은 큐에 넣는다.
5. input 문자열 길이가 짝수일 때는 큐와 스택의 크기가 같을 때만 문자를 만들고,
6. 홀수일 때는 큐와 스택의 크기 차가 1일 때만 문자를 만든다.
7. 문자를 만드는 방법은 큐에서 하나씩 꺼내 string에 붙이고, 스택에서 하나씩 꺼내 string에 붙이면 된다.
```cpp
	int i = 0;
	while (i < 26) {
		if (alphabet[i] <= 1) {
			i++;
		}
		else if (alphabet[i] > 1) {
			front.push('A' + i);
			back.push('A' + i);
			alphabet[i] -= 2;
			i = 0;
			continue;
		}
	}

	for (int i = 0; i < 26; i++) {
		if (alphabet[i] != 0) {
			front.push('A' + i);
			alphabet[i]--;
		}
	}

	string result;
	if ((input.length() % 2 == 0 && front.size() == back.size()) || (input.length() % 2 != 0 && front.size() - back.size() == 1)) {
		result = "";
		while (!front.empty()) {
			result.push_back(front.front());
			front.pop();
		}
		while (!back.empty()) {
			result.push_back(back.top());
			back.pop();
		}
	}
	else {
		result = "I'm Sorry Hansoo";
	}
```

## :black_nib: **Review**
- [Wii Shop Channel Theme HQ | Wii music (1 HOUR)](https://www.youtube.com/watch?v=vIbK3GUr6uI)
- 오늘은 다른 노래를 들어봤어요! Wii에 Shop 노래 경쾌하고 좋아용
- 닌텐도는 최고야!

## 📡 Link
[https://www.acmicpc.net/problem/1213](https://www.acmicpc.net/problem/1213)
