# [백준 - S4] 30890. 드럼

## ⏰ **time**

15분

## :pushpin: **Algorithm**

- 수학

## ⏲️**Time Complexity**

$O(n)$

## :round_pushpin: **Logic**

왼손 연주, 오른손 연주, 양손연주를 할때마다 각각의 연주 회수를 증가시키고 왼손, 오른손의 박자 당 연주회수를 모두 충족하면 break해준다.

```cpp
while (1) {
		time++;
		if (time%x == 0 && time%y == 0) {
			cout << 3;
			xcnt++;
			ycnt++;
		}
		else if (time%x == 0) {
			cout << 2;
			ycnt++;

		}
		else if (time%y == 0) {
			cout << 1;
			xcnt++;
		}
		if (ycnt == y && xcnt == x) {
			break;
		}

	}
```

## :black_nib: **Review**

## 📡**Link**

- https://www.acmicpc.net/problem/30890
