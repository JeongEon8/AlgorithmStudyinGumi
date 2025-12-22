# [백준 - 실버 3] 4779. 칸토어 집합

## ⏰  **time**
2시간

## :pushpin: **Algorithm**
재귀

## ⏲️**Time Complexity**
$O((NlogN))$

## :round_pushpin: **Logic**
1. vector에서 시작점을 꺼낸다.
2. 길이를 계산한다.
3. `길이 / 3`한 몫이 지우기 시작포인트이다.
4. 몫 + 몫이 지우기 끝 포인트이다.
5. 끝포인트를 vector에 추가한다.
6. cnt - 1한 상태로 재귀
```cpp
void recursion(int cnt) {
	if (cnt == 0) {
		cout << bar << '\n';
		return;
	}

	int size = vec.size();
	for (int i = 0; i < size; i++) {
		int start = vec[i];
		int len = pow(3, cnt);
		int eraseStartpt = len / 3;
		int eraseEndpt = (len / 3) + (len / 3);

		for (int j = start + eraseStartpt; j < start + eraseEndpt; j++) {
			bar[j] = ' ';
		}
		vec.push_back(start + eraseEndpt);
	}
	recursion(cnt - 1);
}
```

## :black_nib: **Review**
- 재활이 시급합니다. 이거 푸는데 2시간이나 걸렸습니다. 다 까먹었습니다.

## 📡 Link
https://www.acmicpc.net/problem/4779
