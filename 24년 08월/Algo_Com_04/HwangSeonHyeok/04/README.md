# [백준 - s3] 1448. 삼각형 만들기

## ⏰ **time**

20분

## :pushpin: **Algorithm**

- 수학
- 그리디 알고리즘
- 정렬

## :round_pushpin: **Logic**

삼각형은 성립 조건인 한변의 길이 < 다른 두변 길이의 합이므로 입력을 내림차순으로 정렬하고 length[i] < length[i + 1] + length[i + 2]을 만족하는 첫번째 i일때의 세 변의 길이 합을 답으로 구할 수 있다.

```cpp
   Arrays.sort(length, Collections.reverseOrder());
		int ans = -1;
		for (int i = 0; i < n - 2; i++) {
			if (length[i] < length[i + 1] + length[i + 2]) {
				ans = length[i] + length[i + 1] + length[i + 2];
				break;
			}
		}

```

## :black_nib: **Review**

## 📡**Link**

- https://www.acmicpc.net/problem/1448
