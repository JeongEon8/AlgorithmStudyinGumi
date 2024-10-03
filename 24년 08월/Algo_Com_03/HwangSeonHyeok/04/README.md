# [백준 - s4] 25955. APC는 쉬운 난이도 순일까, 아닐까?

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 구현
- 정렬

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**

map을 통해 브, 실, 골, 플, 다 높은 등급에 높은 수를 할당해서 비교연산자를 구현하여 정렬하고 정렬한 vector, 원본 vector를 비교해서 순서가 바뀐게 있는지 찾는다.

```cpp
map<char, int> m;
m['B'] = 0;
m['S'] = 1;
m['G'] = 2;
m['P'] = 3;
m['D'] = 4;
bool cmp(string a, string b) {
	if (a[0] == b[0]) {
		int scoreA = stoi(a.substr(1, a.size() - 1));
		int scoreB = stoi(b.substr(1, b.size() - 1));
		return scoreA > scoreB;
	}
	else {
		return m[a[0]] < m[b[0]];
	}
}

```

## :black_nib: **Review**

- 비교연산자를 구현해야하는 문제

## 📡**Link**

- https://www.acmicpc.net/problem/25955
