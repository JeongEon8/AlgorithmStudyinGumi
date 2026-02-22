# [백준 - 실버 2] 1254. 팰린드롬 만들기

## ⏰ **time**
15분

## :pushpin: **Algorithm**
백터, 정렬

## ⏲️ **Time Complexity**
$O(NlogN)$

## :round_pushpin: **Logic**
1. 10보다 크면 10자리 수랑 1자리 수랑 영어로 번역해서 string을 넣는다.
2. 10보다 작으면 1자리 수를 영어로 번역해서 string에 넣는다.
3. sort를 이용해서 영어가 더 작은 걸로 정렬한다.
```cpp
	for (int i = M; i <= N; i++) {
		if (i >= 10) {
			s = nums[i / 10] + " " + nums[i % 10];
			result.push_back({ s,i });
		}
		else {
			s = nums[i % 10];
			result.push_back({ s,i });
		}
	}

	sort(result.begin(), result.end());
```

## :black_nib: **Review**
- [Wii Shop Channel Theme HQ | Wii music (1 HOUR)](https://www.youtube.com/watch?v=vIbK3GUr6uI)
- 오늘은 다른 노래를 들어봤어요! Wii에 Shop 노래 경쾌하고 좋아용
- 닌텐도는 최고야!

## 📡 Link
[https://www.acmicpc.net/problem/1755](https://www.acmicpc.net/problem/1755)
