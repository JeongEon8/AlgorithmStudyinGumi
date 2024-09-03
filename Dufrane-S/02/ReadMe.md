# [SWEA - D3] 25955. APC는 쉬운 난이도 순일까, 아닐까?

## ⏰ **time**

120분

## :pushpin: **Algorithm**

- 완전탐색?

## :round_pushpin: **Logic**

큰 자리 수가 작은 수이고 작은 자리 수가 클 때 자리를 바꾸어준다를 기본 논리로 이것저것 조건을 달아 주었다...

```cpp
void change(string s, int idx,  int count) {
	if (count == a) {
		if (answer < stoi(s))answer = stoi(s);
		return;
	}
	if (idx == s.size()) {
		if ((a - count) % 2 == 0) {
			if (answer < stoi(s))answer = stoi(s);
			return;
		}
		else {
			char temp = s[s.size() - 1];
			s[s.size() - 1] = s[s.size() - 2];
			s[s.size() - 2] = temp;
			if (answer < stoi(s))answer = stoi(s);
			return;
		}
	}
	int now = s[idx] - '0';
	int large = now;
	vector<int>largeidx;
	for (int i = idx + 1; i < s.size(); i++) {
		int temp = s[i] - '0';
		if (temp > large) {
			large = temp;
			largeidx.clear();
			largeidx.push_back(i);
		}
		else if (temp == large) {
			largeidx.push_back(i);
		}
	}
	if(large!=now){
		for (auto i : largeidx) {
			string tmp = s;
			char temp = tmp[i];
			tmp[i] = tmp[idx];
			tmp[idx] = temp;
			change(tmp, idx+1 , count + 1);
		}
	}
	else if (large == now && !largeidx.empty()) {
		change(s, idx + 1, count + 1);
		change(s, idx , count + 1);
	}
	else if (large == now) {
		change(s, idx + 1, count);
	}
	else {
		if (idx == s.size() - 1) {
			if ((a - count) % 2 == 0) {
				if (answer < stoi(s))answer = stoi(s);
				return;
			}
			else {
				char temp = s[s.size() - 1];
				s[s.size() - 1] = s[s.size() - 2];
				s[s.size() - 2] = temp;
				if (answer < stoi(s))answer = stoi(s);
				return;
			}
		}
		else {
			change(s, idx + 1, count);
		}
		
	}
}

```

## :black_nib: **Review**

- 모르겠음

## 📡**Link**

- https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV15Khn6AN0CFAYD&categoryId=AV15Khn6AN0CFAYD&categoryType=CODE&problemTitle=%EC%B5%9C%EB%8C%80+%EC%83%81%EA%B8%88&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1
