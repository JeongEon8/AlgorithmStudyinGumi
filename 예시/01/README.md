# [SWEA - D3️] 1860. 진기의 최고급 붕어빵
 
## ⏰  **time**

20분

## :pushpin: **Algorithm**

구현

## ⏲️**Time Complexity**

$O(NlogN)$

## :round_pushpin: **Logic**
1. 붕어빵 굽는 시간에 맞춰서 왔을 때 ➡️ fishbread줄이기
   if) 붕어빵이 없다면 ➡️ impossible
2. 지금 시간과 다음 붕어빵 굽는 시간에 왔을 때 ➡️ fishbread 줄이기
   if) 붕어빵이 없다면 ➡️ impossible
3. 만약 지금 시간보다 큰 시간이 나타나면 ➡️ 다음 붕어빵 굽는 시간으로 이동
```cpp
		for (int i = 0; i < N; i++) {
			if (man[i] == time) {
				if (fishbread <= 0) {
					result = false;
					break;
				}
				fishbread--;
			}
			else if (man[i] > time && man[i] < time + M) {
				if (fishbread <= 0) {
					result = false;
					break;
				}
				fishbread--;
			}
			else {
				i--;
				time += M;
				fishbread += K;
			}
		}
```

## :black_nib: **Review**
- 0초일 때를 포함 안해서 틀렸다.. 으악
