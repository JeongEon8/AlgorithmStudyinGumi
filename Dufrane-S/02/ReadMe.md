# [백준 - G3] 14890. 경사로
 
## ⏰  **time**
40분

## :pushpin: **Algorithm**
구현


## :round_pushpin: **Logic**
1. 라인의 숫자들을 숫자별로 묶어주고 계
```
for (int i = 0; i < n; i++) {
		if (now != box[i][j]) {
			now = box[i][j];
			v.push_back(nowp);
			nowp = { now,1 };
		}
		else {
			nowp.second++;
		}
	}
	v.push_back(nowp);
	for (int i = 0; i < v.size() - 1; i++) {
		if (abs(v[i].first - v[i + 1].first) >= 2)return false;
		if (v[i].first > v[i + 1].first) {
			if (v[i + 1].second < m) {
				return false;
			}
			else {
				v[i + 1].second -= m;
			}
		}
		else if (v[i].first < v[i + 1].first) {
			if (v[i].second < m) {
				return false;
			}

		}
	}
	return true;
```

## :black_nib: **Review**
- .



## 📡 Link
[https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V4A46AdIDFAWu](https://www.acmicpc.net/problem/14890)
